package com.gzw.mp.activities;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gzw.mp.R;
import com.gzw.mp.base.BaseActivity;
import com.gzw.mp.utils.LogUtil;
import com.gzw.mp.utils.UIHelper;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Grrsun
 * 美拍视频页详情
 *
 */
public class MeipaiDetailActivity extends BaseActivity {

    private final static int NETWORK_PARSE_ERROE = 0;
    private final static int VIDEO_FILE_ERROR = 1;
    private final static int VIDEO_STATE_BEGIN = 2;
    private final static int VIDEO_CACHE_FINISH = 3;
    private final static int VIDEO_PREPARED = 4;
    private final static int VIDEO_UPDATE_SEEKBAR = 5;
    private final static int HIDE_CONTROL_VIEW = 6;

    @ViewInject(R.id.play_video)
    ImageView mPlayVideo;//开始播放视频的按钮
    @ViewInject(R.id.video_surfaceview)
    SurfaceView mSurfaceView;//
    @ViewInject(R.id.video_seekbar)
    SeekBar mSeekBar;//SeekBar 进度条
    @ViewInject(R.id.video_control_layout)
    RelativeLayout mControlLayout;
    @ViewInject(R.id.videoloading_progressbar)
    ProgressBar mProgressBar;//ProgressBar 缓冲
    @ViewInject(R.id.hasplay_time)
    TextView mHasPlayTime;//已播放时间
    @ViewInject(R.id.total_time)
    TextView mTotalTime;//视频总时长

    private String url = "http://mvvideo1.meitudata.com/5643f658725324126.mp4";//视频地址
    private MediaPlayer mPlayer;//播放控件
    private int postSize;//保存播放已播放大小
    private boolean flag = true;//判断视频是否正在播放
    private boolean display;//是否显示其他按钮
    private UpdataSeekBar updataSeekBar;//更新进度条
    private long mediaLength = 0, readSize = 0;
    private Timer mTimer ;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //接收子线程返回的信息
            switch (msg.what) {
                case HIDE_CONTROL_VIEW:
                    //隐藏播放控件
                    mControlLayout.setVisibility(View.GONE);
                    break;
                //视频已准备好播放
                case VIDEO_PREPARED:
                    //获取视频总长度
                    int max = (int) msg.obj;
                    //转换一下格式
                    int minutes = max / 1000 / 60 % 60;
                    int seconds = max / 1000 % 60;
                    String totalTime = String.format("%02d:%02d", minutes, seconds);
                    mTotalTime.setText(totalTime);
                    break;
                //网络错误信息
                case NETWORK_PARSE_ERROE:
                    //弹出网络错误提示
                    UIHelper.ToastUtil(getApplicationContext(), "网络连接错误,无法播放视频!");
                    //隐藏ProgressBar
                    mProgressBar.setVisibility(View.GONE);
                    break;
                //视频错误
                case VIDEO_FILE_ERROR:
                    UIHelper.ToastUtil(getApplicationContext(), "视频文件错误!");
                    mProgressBar.setVisibility(View.GONE);
                    break;
                //开始播放视频
                case VIDEO_STATE_BEGIN:
                    //播放视频
                    playVideoMetod();
                    //改变按钮样式
                    // TODO: 2015/11/12
                    break;
                //视频缓存完成  改用本地文件播放
                case VIDEO_CACHE_FINISH:
                    UIHelper.ToastUtil(getApplicationContext(), "视频缓存完成!");
                    //获取播放进度
                    postSize = mPlayer.getCurrentPosition();
                    //播放视频
                    playVideoMetod();
                    break;
                //更新进度条
                case VIDEO_UPDATE_SEEKBAR:
                    //判断视频是否正在播放
                    if (mPlayer == null) {
                        flag = false;
                    } else {
                        double cacahepercent = readSize * 100.00 / mediaLength * 1.0;
                        // String s = String.format("已缓存:[%.2f%%]", cacahepercent);
                        String s = "";
                        if (mPlayer.isPlaying()) {
                            flag = true;
                            int position = mPlayer.getCurrentPosition();
                            int mMax = mPlayer.getDuration();
                            // LogUtil.i("---Duration",mMax);
                            int sMax = mSeekBar.getMax();
                            mSeekBar.setProgress(position * sMax / mMax);
                            mMax = 0 == mMax ? 1 : mMax;
                            double playpercent = position * 100.00 / mMax * 1.0;
                            int i = position / 1000;
                            int hour = i / (60 * 60);
                            int minute = i / 60 % 60;
                            int second = i % 60;
                            s = String.format("%02d:%02d", minute, second);
                        } else {
                            int position = mPlayer.getCurrentPosition();
                            int i = position / 1000;
                            int minute = i / 60 % 60;
                            int second = i % 60;
                            s = String.format("%02d:%02d", minute, second);
                        }
                        mHasPlayTime.setText(s);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_meipaidetail;
    }

    @Override
    public void initView() {
        //初始化View
        initVideoPlayer();
        setPalyerListener();
    }

    @Override
    public void initAction() {
        mTimer=new Timer();
    }

    /**
     * 定时器 一段时间后无操作就隐藏播放控制控件
     */
    private void setTimerTask(){
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(HIDE_CONTROL_VIEW);
            }
        },5000);
    }

    /**
     * 初始化View
     */
    private void initVideoPlayer() {
        //创建一个播放器对象
        mPlayer = new MediaPlayer();
        //创建更新进度条对象
        updataSeekBar = new UpdataSeekBar();
        //初始化时隐藏其他控件
        mPlayVideo.setVisibility(View.GONE);
        mControlLayout.setVisibility(View.GONE);
        //不缓冲
        mSurfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        //屏幕常量
        mSurfaceView.getHolder().setKeepScreenOn(true);
        //设置监听事件 从此处监听视频缓冲完成到播放
        mSurfaceView.getHolder().addCallback(new videoSurfaceView());
    }

    //视频播放回调事件
    private class videoSurfaceView implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

            if (URLUtil.isNetworkUrl(url)) {//网络视频
                try {
                    //播放并缓冲到本地
                    new Thread(new CacheNetFileR()).start();
                } catch (Exception e) {
                    mHandler.sendEmptyMessage(NETWORK_PARSE_ERROE);
                    e.printStackTrace();
                }
            } else {
                File videoFile = new File(url);
                if (videoFile.exists()) {
                    readSize = mediaLength = videoFile.length();
                    System.out.println("这是本地视频,直接播放!");
                    mHandler.sendEmptyMessage(VIDEO_STATE_BEGIN);
                }
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (mPlayer != null && mPlayer.isPlaying()) {
                postSize = mPlayer.getCurrentPosition();
                mPlayer.stop();
                flag = false;
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    //播放视频的线程
    class PlayMovieT extends Thread {
        int post = 0;

        public PlayMovieT(int post) {
            this.post = post;
        }

        @Override
        public void run() {
            try {
                mPlayer.reset();    //回复播放器默认
                mPlayer.setDataSource(url);   //设置播放路径
                mPlayer.setDisplay(mSurfaceView.getHolder());  //把视频显示在SurfaceView上
                mPlayer.setOnPreparedListener(new videoPreparedL(post));  //设置监听事件
                mPlayer.prepare();  //准备播放
                Message msg = new Message();
                msg.what = VIDEO_PREPARED;
                msg.obj = mPlayer.getDuration();
                mHandler.sendMessage(msg);
            } catch (Exception e) {
                mHandler.sendEmptyMessage(VIDEO_FILE_ERROR);
            }
            super.run();
        }
    }

    //视频播放视图准备事件监听器
    class videoPreparedL implements MediaPlayer.OnPreparedListener {
        int postSize;

        public videoPreparedL(int postSize) {
            this.postSize = postSize;
        }

        @Override
        public void onPrepared(MediaPlayer mp) {//准备完成
            mProgressBar.setVisibility(View.GONE);  //准备完成后，隐藏控件
            mControlLayout.setVisibility(View.GONE);
            display = false;
            if (mPlayer != null) {
                mPlayer.start();  //开始播放视频
            } else {
                return;
            }
            if (postSize > 0) {  //说明中途停止过（activity调用过pause方法，不是用户点击停止按钮），跳到停止时候位置开始播放
                mPlayer.seekTo(postSize);   //跳到postSize大小位置处进行播放
            }
            new Thread(updataSeekBar).start();   //启动线程，更新进度条
        }
    }

    //设置操作监听器
    private void setPalyerListener() {
        mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {//缓冲去更新
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
            }
        });

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //视频播放完成
            @Override
            public void onCompletion(MediaPlayer mp) {
                flag = false;
                // mPlayVideo.setBackgroundResource(R.drawable.btn_play);
            }
        });

        //如果视频在播放，则调用mediaPlayer.pause();，停止播放视频，反之，mediaPlayer.start()  ，同时换按钮背景
        mPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer.isPlaying()) {
                    if (mTimer!=null){
                        mTimer.cancel();
                    }
                    mPlayVideo.setVisibility(View.VISIBLE);
                    mPlayVideo.setBackgroundResource(R.drawable.btn_video_play_selector);
                    mPlayer.pause();
                    postSize = mPlayer.getCurrentPosition();
                    LogUtil.i("---onClick", "点击了播放按钮 暂停播放");
                } else {
                    if (flag == false) {
                        flag = true;
                        new Thread(updataSeekBar).start();
                    }
                    mPlayer.start();
                    mPlayVideo.setBackgroundResource(R.drawable.btn_video_play_selector);
                    mPlayVideo.setEnabled(false);
                    mPlayVideo.setVisibility(View.GONE);
                    if (mTimer!=null){
                        mTimer.cancel();
                        mTimer=new Timer();
                        setTimerTask();
                    }
                    LogUtil.i("---onClick", "点击了播放按钮 开始播放");
                }
            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int value = mSeekBar.getProgress() * mPlayer.getDuration() / mSeekBar.getMax();  //计算进度条需要前进的位置数据大小
                mPlayer.seekTo(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
        });
        //点击屏幕，切换控件的显示，显示则应藏，隐藏，则显示
        mSurfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mPlayer.isPlaying()) {
                    //开始播放
                    mPlayer.start();
                    //隐藏控件
                    mPlayVideo.setEnabled(false);
                    mPlayVideo.setVisibility(View.GONE);
                    //5s后执行一次定时器
                    if (mTimer!=null){
                        mTimer.cancel();
                        mTimer=new Timer();
                        setTimerTask();
                    }
                    //display = false;
                    LogUtil.i("---onClick", "点击了屏幕 开始播放");
                } else {
                    //暂停播放
                    if (mTimer!=null){
                        mTimer.cancel();
                    }
                    mPlayer.pause();
                    mPlayVideo.setEnabled(true);
                    //显示控件
                    mSurfaceView.setVisibility(View.VISIBLE);
                    mPlayVideo.setVisibility(View.VISIBLE);
                    mControlLayout.setVisibility(View.VISIBLE);
                    mHasPlayTime.setVisibility(View.VISIBLE);
                    display = true;
                    LogUtil.i("---onClick", "点击了屏幕 暂停播放");
                }
            }
        });
    }

    /**
     * 播放视频
     */
    private void playVideoMetod() {
        if (postSize > 0 && url != null) {
            new PlayMovieT(postSize).start();//从postSize位置开始放
            flag = true;
            int sMax = mSeekBar.getMax();
            int mMax = mPlayer.getDuration();
            mSeekBar.setProgress(postSize * sMax / mMax);
            mProgressBar.setVisibility(View.GONE);
        } else {
            new PlayMovieT(0).start();//表明是第一次开始播放
        }
    }

    /**
     * 现在开始,用英文注释吧
     * update the SeekBar
     */
    class UpdataSeekBar implements Runnable {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(VIDEO_UPDATE_SEEKBAR);
            if (flag) {
                mHandler.postDelayed(updataSeekBar, 10);
            }
        }
    }

    @Override
    protected void onDestroy() {   //activity销毁后，释放资源
        super.onDestroy();
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        System.gc();
    }

    /**
     * 在线播放时后台缓存文件,方便下次直接播放
     */
    class CacheNetFileR implements Runnable {
        @Override
        public void run() {
            LogUtil.i("---CacheVideo", "begin to cache the video!");
            FileOutputStream out = null;
            InputStream is = null;
            try {
                HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
                String cacheUrl = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Cache/" + url.substring(url.lastIndexOf("/") + 1);
                File cacheFile = new File(cacheUrl);
                boolean isNeedCache = false;
                if (cacheFile.exists()) {
                    readSize = mediaLength = cacheFile.length();
                    httpConnection.setRequestProperty("User-Agent", "NetFox");
                    httpConnection.setRequestProperty("RANGE", "bytes=" + readSize + "-");//从断点处请求读取文件
                    if (httpConnection.getContentLength() == readSize) {//视频已经成功缓存完成
                        url = cacheUrl;
                        isNeedCache = false;
                    } else {
                        isNeedCache = true;
                    }
                } else {
                    cacheFile.getParentFile().mkdirs();
                    cacheFile.createNewFile();
                    isNeedCache = true;
                }
                mHandler.sendEmptyMessage(VIDEO_STATE_BEGIN);//开始播放视频
                if (isNeedCache) {//需要缓存视频
                    out = new FileOutputStream(cacheFile, true);

                    is = httpConnection.getInputStream();
                    mediaLength = httpConnection.getContentLength();
                    if (-1 == mediaLength) {
                        LogUtil.i("---Failed to cache", "the file failed to cache,could not play! ");
                        return;
                    }
                    mediaLength += readSize;

                    byte buf[] = new byte[4 * 1024];
                    int size = 0;

                    while ((size = is.read(buf)) != -1) {//缓存文件
                        LogUtil.i("---caching", size);
                        try {
                            out.write(buf, 0, size);
                            readSize += size;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    url = cacheUrl;//将url替换成本地
                    mHandler.sendEmptyMessage(VIDEO_CACHE_FINISH);//视频缓存结束,将当前视频切换成播放本地的文件
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }
}

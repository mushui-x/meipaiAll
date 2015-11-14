package com.gzw.mp.activities;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.gzw.mp.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 
 * @author Grrsun
 *
 */
public class CaptureVideoActivity extends FragmentActivity implements OnGestureListener {

	private int FLAG = 0;

	private Camera mCamera;

	@ViewInject(R.id.capture_picture)
	LinearLayout mCapturePictureLayout;
	@ViewInject(R.id.capture_video)
	LinearLayout mCaptureVideoLayout;
	@ViewInject(R.id.capture_longvideo)
	LinearLayout mCaptureLongVideoLayout;

	private GestureDetector mDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 设为全屏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capturevideo);
		ViewUtils.inject(this);
		mDetector = new GestureDetector(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 打开相机
		mCamera = Camera.open();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 失去焦点时释放相机
		mCamera.release();
		// 将相机置空 Android垃圾回收期发现资源为空后 会自动将其收回
		mCamera = null;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mDetector.onTouchEvent(event);
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		changeLayout(velocityX);
		return false;
	}

	/**
	 * 手势滑动改变底部Layout 从而切换拍照,录制视频
	 * 
	 * @param velocityX
	 */
	private void changeLayout(float velocityX) {
		if (FLAG == 0) {
			if (velocityX < 0) {
				System.out.println("<--左划");
				mCapturePictureLayout.setVisibility(View.GONE);
				mCaptureVideoLayout.setVisibility(View.GONE);
				mCaptureLongVideoLayout.setVisibility(View.VISIBLE);
				FLAG = 1;
			} else if (velocityX > 0) {
				System.out.println("右划-->");
				mCapturePictureLayout.setVisibility(View.VISIBLE);
				mCaptureVideoLayout.setVisibility(View.GONE);
				mCaptureLongVideoLayout.setVisibility(View.GONE);
				FLAG = -1;
			}
		}
		if (FLAG == 1) {
			if (velocityX < 0) {

			} else if (velocityX > 0) {
				System.out.println("右划-->");
				mCapturePictureLayout.setVisibility(View.GONE);
				mCaptureVideoLayout.setVisibility(View.VISIBLE);
				mCaptureLongVideoLayout.setVisibility(View.GONE);
				FLAG = 0;
			}
		}
		if (FLAG == -1) {
			if (velocityX < 0) {
				System.out.println("<--左划");
				mCapturePictureLayout.setVisibility(View.GONE);
				mCaptureVideoLayout.setVisibility(View.VISIBLE);
				mCaptureLongVideoLayout.setVisibility(View.GONE);
				FLAG = 0;
			} else if (velocityX > 0) {

			}
		}
	}
}

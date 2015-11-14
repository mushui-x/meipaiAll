package com.gzw.mp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzw.mp.R;
import com.gzw.mp.bean.MediaBean;
import com.gzw.mp.utils.ImageLoadUtil;
import com.gzw.mp.view.RoundImageView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**两列的视频Adapter
 * coder by 背离记 on 2015/11/13.
 */
public class MediaListAdapter2 extends BaseAdapter{
    private List<MediaBean> list ;
    private Context context;

    public MediaListAdapter2(Context context,List<MediaBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.video_single_show_layout, null);
            holder = new ViewHolder();
            ViewUtils.inject(holder,convertView);
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        MediaBean bean =list.get(position);
        //视频封面
        String corverUrl = bean.getCover_pic();
        String captionText = bean.getCaption();
        ImageLoadUtil.loadImage(corverUrl, holder.corver);
        holder.caption.setText(captionText);
        //用户头像
        String corverUser = bean.getUser().getAvatar();
        int lickNum = bean.getLikes_count();
        ImageLoadUtil.loadImage(corverUser, holder.avatar);
       holder.likeCount.setText(lickNum+"");
        return convertView;
    }

    class ViewHolder{
        //视频封面
        @ViewInject(R.id.recommend_cover_pic)
        ImageView corver;
        //用户头像
        @ViewInject(R.id.avatar)
        RoundImageView avatar;
        //标题
        @ViewInject(R.id.recommend_caption)
        TextView caption;
        //点赞数前边的心形图片
        @ViewInject(R.id.licks_image)
        ImageView lickImage;
        //点赞数
        @ViewInject(R.id.likes_count)
        TextView likeCount;
        //活动标题
        @ViewInject(R.id.activity)
        TextView activityTitle;
    }
}

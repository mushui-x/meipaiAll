package com.gzw.mp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gzw.mp.MyApplication;
import com.gzw.mp.R;
import com.gzw.mp.bean.User;
import com.gzw.mp.utils.ImageLoadUtil;
import com.gzw.mp.utils.LogInDialog;

public class UserFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.user_fragemnt, null);
        Bundle bundle = getArguments();
        //不为空
        // 则美拍,转发,关注,粉丝--- 取消隐藏使其显示
        //赞,@我的 ,评论,私信,赞---取消隐藏使其显示
        if (bundle != null) {
            User user = (User) bundle.getSerializable("user");
            if (user!=null){
                showUserInfo(view, user);
            }
        }
        initView(view);
        return view;
    }

    /*
    *显示用户界面及信息
    * mLlUserInfo:美拍 转发 关注 粉丝
    * mLlAboutMe:赞,@我的 ,评论,私信
    * 设置相关显示信息
     */
    private void showUserInfo(View view, User user) {
        LinearLayout mLlUserInfo = (LinearLayout) view.findViewById(R.id.user_ll_info);
        LinearLayout mLlAboutMe = (LinearLayout) view.findViewById(R.id.user_ll_aboutme);
        TextView tv_tosee = (TextView) view.findViewById(R.id.user_login_tosee);
        mLlUserInfo.setVisibility(View.VISIBLE);
        mLlAboutMe.setVisibility(View.VISIBLE);
        tv_tosee.setVisibility(View.GONE);
        //用户头像
        ImageLoadUtil.loadImage(user.getAvatar(), (ImageView) view.findViewById(R.id.iv_user));
        //用户昵称
        TextView tv_user_name = (TextView) view.findViewById(R.id.tv_user_sign);
        tv_user_name.setText(user.getScreen_name());

        //mLlUserInfo的子view
        //视频总数 -
        mLlUserInfoSetString(view, R.id.user_tv_videos_count, user.getVideos_count());
        //用 户转发数
        mLlUserInfoSetString(view, R.id.user_tv_transpond_count, user.getReposts_count());
        //用 户关注数
        mLlUserInfoSetString(view, R.id.user_tv_focus_count, user.getFriends_count());
        //用 户粉丝数
        mLlUserInfoSetString(view, R.id.user_tv_focus_count, user.getFollowers_count());

        //mLlAboutMe的子view _____-1为未解析
        //赞
        mLlAboutMeSetString(view, R.id.user_tv_be_liked_count, user.getBe_liked_count());
        //@我的
        mLlAboutMeSetString(view, R.id.user_tv_be_at_count, -1);
        //评论
        mLlAboutMeSetString(view, R.id.user_tv_be_comment_count, -1);
        //私信
        mLlAboutMeSetString(view, R.id.user_tv_privatemsg_count, -1);


    }

    //mLlUserInfo:美拍 转发 关注 粉丝的 所在TextView赋值
    private void mLlUserInfoSetString(View view, int rId, int num) {
        TextView tv = (TextView) view.findViewById(rId);
        tv.setText(num + "");
    }

    //mLlAboutMe:美拍 转发 关注 粉丝的 所在TextView赋值
    private void mLlAboutMeSetString(View view, int rId, int num) {
        TextView tv = (TextView) view.findViewById(rId);
        //-1为数据未解析
        if (num == 0) {
            tv.setVisibility(View.GONE);
        } else {
            tv.setText(num + "");
        }
    }

    //初始化界面
    private void initView(View view) {
        RelativeLayout ll_login = (RelativeLayout) view.findViewById(R.id.user__rl_login);
        LinearLayout ll_draft = (LinearLayout) view.findViewById(R.id.user__ll_draft);
        LinearLayout ll_findfrend = (LinearLayout) view.findViewById(R.id.user__ll_findfrend);
        LinearLayout ll_mapattention = (LinearLayout) view.findViewById(R.id.user__ll_mapattention);
        ll_login.setOnClickListener(this);
        ll_draft.setOnClickListener(this);
        ll_findfrend.setOnClickListener(this);
        ll_mapattention.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!MyApplication.loginFlag) {
            LogInDialog.showLogInDialog(getActivity());
        } else if (MyApplication.loginFlag) {

        }
    }
}

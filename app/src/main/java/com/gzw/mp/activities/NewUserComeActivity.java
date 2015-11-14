package com.gzw.mp.activities;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.gzw.mp.R;
import com.gzw.mp.adapter.MediaListAdapter2;
import com.gzw.mp.base.BaseActivity;
import com.gzw.mp.bean.MediaBean;
import com.gzw.mp.utils.APIUtils;
import com.gzw.mp.utils.JsonParser;
import com.gzw.mp.utils.UIHelper;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * coder by 背离记 on 2015/11/13.
 */
public class NewUserComeActivity extends BaseActivity{
    List<MediaBean> list =new ArrayList<>();
    @ViewInject(R.id.gridView_newUserCome)
    GridView gridView;
    @ViewInject(R.id.phone_login_iv_back)
    ImageView view;

    @Override
    public int getLayoutId() {
        return R.layout.new_user_come;
    }

    @Override
    public void initView() {
        String url = APIUtils.getNewUserLink(1);
        UIHelper.getStringFromNet(url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
               list= JsonParser.getMediaList(responseInfo.result);
                MediaListAdapter2 adapter =new MediaListAdapter2(NewUserComeActivity.this,list);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

    @Override
    public void initAction() {
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    }
}

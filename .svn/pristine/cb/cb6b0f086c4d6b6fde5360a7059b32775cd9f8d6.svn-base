package com.gzw.mp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;

import com.gzw.mp.R;
import com.gzw.mp.activities.MeipaiDetailActivity;
import com.gzw.mp.adapter.VideoShowBaseAdapter;
import com.gzw.mp.bean.TimeLineBean;
import com.gzw.mp.utils.JsonParser;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * author Grrsun
 */
public class HomeTabFragment extends Fragment {

    @ViewInject(R.id.video_show_layout)
    GridView videoShowLayout;

    //放TimeLine豆子 也就是首页的视频列表
    private List<TimeLineBean> timeLineData;
    // private String HotUrl = APIUtils.getTimeLineLinkById("1", 1);
    private String HotUrl = "https://newapi.meipai.com/channels/feed_timeline.json?id=1&feature=new&page=1";
    private VideoShowBaseAdapter mAdapter;
    private static final String ARG_POSITION = "position";

    private int position;

    public static HomeTabFragment newInstance(int position) {
        HomeTabFragment f = new HomeTabFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);
        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());
        View v = inflater.inflate(R.layout.top_tab_item_hot, container, false);
        fl.addView(v);
        ViewUtils.inject(this, v);
        initData();
        initView();
        return fl;
    }

    private void initView() {
        videoShowLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MeipaiDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 获取数据
     */
    private void initData() {
        HttpUtils httpUtils = new HttpUtils(5000);
        httpUtils.send(HttpRequest.HttpMethod.GET, HotUrl, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                timeLineData = JsonParser.getTimeLine(responseInfo.result);
                mAdapter = new VideoShowBaseAdapter(getActivity(), timeLineData);
                videoShowLayout.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }
}
package com.gzw.mp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzw.mp.R;
import com.gzw.mp.adapter.HomeFragmentPagerAdapter;
import com.gzw.mp.bean.ChnnelBean;
import com.gzw.mp.view.HomeTabIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * author Grrsun
 */
public class HomeFragment extends Fragment {

    private HomeTabIndicator tabIndicator;
    private ViewPager viewpager;
    private HomeFragmentPagerAdapter adapter;
    private List<String> category = new ArrayList<String>();

    /**
     * Tab 栏目标题获取完后Handler更新ui
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //获取List数据
            category = (List<String>) msg.obj;
            //设置Adapter
            adapter = new HomeFragmentPagerAdapter(getFragmentManager(),category);
            viewpager.setAdapter(adapter);
            //Tab绑定ViewPager
            tabIndicator.setViewPager(viewpager);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //初始化View
        initView(view);
        return view;
    }

    /**
     * 初始化View
     *
     * @param view
     */
    protected void initView(View view) {
        tabIndicator = ((HomeTabIndicator) view.findViewById(R.id.home_tab_indicator));
        viewpager = ((ViewPager) view.findViewById(R.id.home_viewpager));
        int i = 0;
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 15; i++) {
                    category.add(ChnnelBean.getChnnel().get(i).getChnnelTitle());
                }
                Message msg = new Message();
                msg.what = 1;
                msg.obj = category;
                mHandler.sendMessage(msg);
            }
        }.start();
    }
}

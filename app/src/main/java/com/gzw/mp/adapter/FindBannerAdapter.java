package com.gzw.mp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * coder by 背离记 on 2015/11/13.
 */
public class FindBannerAdapter extends PagerAdapter{
    List<ImageView> views =new ArrayList<>();

    public FindBannerAdapter(List<ImageView> views  ) {
        this.views=views;
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = position%views.size();
        container.addView(views.get(index));
        return views.get(index);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position%views.size()));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


}

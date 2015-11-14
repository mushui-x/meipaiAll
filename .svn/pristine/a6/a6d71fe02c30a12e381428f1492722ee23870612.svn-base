package com.gzw.mp.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;

/**
 * coder by 背离记 on 2015/11/6.
 */
public abstract class BaseFragment extends Fragment{

    public SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getViewId(),null);
        ViewUtils.inject(this,view);
        initView();
        initAction();
        return view;
    }

    protected abstract void initView();

    protected abstract void initAction();

    public abstract int getViewId();
    
    
}

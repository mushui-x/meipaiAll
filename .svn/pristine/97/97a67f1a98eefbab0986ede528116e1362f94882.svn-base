package com.gzw.mp.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gzw.mp.MyApplication;
import com.lidroid.xutils.ViewUtils;


/**
 * coder by 背离记 on 2015/11/3.
 */
public abstract class BaseActivity extends FragmentActivity {
    public static String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加Activity到堆栈
        MyApplication.getInstance().addActivity(this);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ViewUtils.inject(this);
        initView();
        initAction();
        TAG = this.getClass().getName();
    }

    /**
     * @return 
     */
    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initAction();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().finishActivity(this);
    }
}

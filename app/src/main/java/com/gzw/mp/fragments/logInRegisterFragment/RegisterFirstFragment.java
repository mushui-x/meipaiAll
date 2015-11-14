package com.gzw.mp.fragments.logInRegisterFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzw.mp.R;

/**
 * Created by Mr.Wang on 2015/11/13 15:18
 */
public class RegisterFirstFragment extends Fragment {

    private Handler handler;

    public RegisterFirstFragment(Handler handler) {
        this.handler = handler;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_register_first, null);
        return view;
    }


}

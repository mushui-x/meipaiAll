package com.gzw.mp.fragments.logInRegisterFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzw.mp.R;


public class RegisterFragmentThird extends Fragment {

    private Handler handler;

    public RegisterFragmentThird(Handler handler) {
        this.handler = handler;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_register_third, null);
        return view;
    }


}

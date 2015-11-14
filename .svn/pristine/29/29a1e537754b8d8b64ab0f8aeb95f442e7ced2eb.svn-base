package com.gzw.mp.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gzw.mp.R;
import com.gzw.mp.activities.LogInRegisterActivity;


/**
 * Created by Mr.Wang on 2015/11/11 11:04
 */
public class LogInDialog {

    public static void showLogInDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.LogInDialogStyle);
        View view = LayoutInflater.from(context).inflate(R.layout.user_login_dialog, null);
        dialog.setContentView(view);
        dialog.show();
        viewListener(view, dialog, context);
    }

    private static void viewListener(View view, final Dialog dialog, final Context context) {
        //左上方关闭按钮的监听
        ImageView iv_close = (ImageView) view.findViewById(R.id.user_login_iv_close);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDismiss(dialog);
            }
        });
        //手机登陆/注册的监听
        LinearLayout register_tel = (LinearLayout) view.findViewById(R.id.user_register_tel);
        register_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LogInRegisterActivity.class);
                context.startActivity(intent);
                dialogDismiss(dialog);
            }
        });
    }

    //取消dialog的显示,并释放资源
    private static void dialogDismiss(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    //登陆错误提示对话框
    public static void errorDialog(Context context, String errorData) {
        final Dialog dialog = new Dialog(context, R.style.LogInErrorDialogStyle);
        View view = LayoutInflater.from(context).inflate(R.layout.login_error_dialog, null);
        TextView tv_msg = (TextView) view.findViewById(R.id.error_dialog_msg);
        if (!errorData.isEmpty()) {
            tv_msg.setText(errorData);
        }
        dialog.setContentView(view);
        dialog.show();
        Button bt_sure = (Button) view.findViewById(R.id.error_dialog_bt);
        bt_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

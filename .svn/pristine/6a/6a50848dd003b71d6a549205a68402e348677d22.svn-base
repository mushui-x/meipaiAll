package com.gzw.mp.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 *
 * @author Grrsun
 * 图片下载工具类
 *
 */

public class ImageLoadUtil {


    public static void loadImage(final String imgUrl, final ImageView imageView) {

        ImageLoader.getInstance().displayImage(imgUrl, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {

            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);

            }

            @Override
            public void onLoadingCancelled(String s, View view) {

            }
        });
    }
}

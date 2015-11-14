package com.gzw.mp.utils;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * coder by 背离记 on 2015/10/27.
 */
public class MD5Encode {

    /**
     * MD5加密方法
     * @param text 要加密的字符串
     * @return 加密后的字符串，注意为空判断
     */
    public static String getMD5Encode(String text){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(text.getBytes());
            byte[] m = messageDigest.digest();//加密
            //对加密后的数据再次操作加密
            StringBuffer sf = new StringBuffer();
            for (byte b:m) {
                int a = b&0xff;
                if(a<16){
                    sf.append(0);
                }
                sf.append(Integer.toHexString(a));
            }
            Log.i("MD5",sf.toString());
            return sf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}

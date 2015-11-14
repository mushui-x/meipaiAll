package com.gzw.mp.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * coder by 背离记 on 2015/11/5.
 */
public class PoolTest {
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Log.i("rec","rec1");
                    break;
                case 2:
                    Log.i("rec","rec2");
                    break;
                case 3:
                    Log.i("rec","rec3");
                    break;
            }
        }
    };
    public PoolTest(){
        ThreadPoolUtil.POOL.execute(test1);
        ThreadPoolUtil.POOL.execute(test3);
        ThreadPoolUtil.POOL.execute(test2);

    }
    
    Runnable test1 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                Log.i("TEST",i+"");
                try {
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    msg.what=1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable test2 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                Log.i("TEST2",i+"");
                try {
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    msg.what=2;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable test3 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                Log.i("TEST3",i+"");
                try {
                    Thread.sleep(1000);
                    Message msg = Message.obtain();
                    msg.what=3;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    
    
    
}

package com.gzw.mp.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * coder by 背离记 on 2015/11/5.
 */
public class ThreadPoolUtil {

    public static ExecutorService  POOL = Executors.newCachedThreadPool();

    /**
     * 将一个Runnable添加到线程池中
     * @param runnable 在runnable中发送handler通信
     */
    public static void addThread(Runnable runnable){
        POOL.execute(runnable);
    }


}

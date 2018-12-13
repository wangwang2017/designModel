package com.yuyuehao.studythread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Wang
 * on 2018-11-20
 */

public class ThreadStudy {

    public void main(String[] args) {
        poolThread();

    }

    public void singleThread(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i="+index);
                    System.out.println(Thread.currentThread().getName() +" index="+index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                }
            });
        }
        singleThreadExecutor.shutdown();
        System.out.println("on the main thread...");
    }

    public void poolThread(){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i="+index);
                    System.out.println(Thread.currentThread().getName()+" index="+index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("exception");
                        e.printStackTrace();
                    }
                }
            });

        }
        newFixedThreadPool.shutdown();
        System.out.println("on the main thread...");
    }
}

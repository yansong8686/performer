package com.mys.concurrency.section3;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch线程辅助类实例
 * 视频会议类
 * Created by manyansong on 2016/11/6.
 */
public class Videoconference implements Runnable{

    private final CountDownLatch controller;

    public Videoconference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.\n",name);
        //每个操作完成后，调用该方法将CountDownLatch类的内部计数器减1
        //当计数器到达0时，所有因await()方法而等待的线程立刻被唤醒，再执行countDown()将不起作用
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization:%d participants.\n",controller.getCount());
        try {
            controller.await();//使用await()等待所有的与会者
            System.out.printf("VideoConference:All the participants have come\n");
            System.out.printf("VideoConference:Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

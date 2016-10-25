package com.mys.concurrency.section1;

import java.util.concurrent.TimeUnit;

/**
 * Created by ASUS on 2016/10/24.
 */
public class Task1_13 implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadFactory1_13 factory = new MyThreadFactory1_13("MyThreadFactory");
        Task1_13 task = new Task1_13();
        Thread thread;
        System.out.printf("Starting the Threads\n");
        //使用线程工厂类Task1_13，创建10个线程对象，并启动它们
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats:\n");
        System.out.println(factory.getStats());
    }
}

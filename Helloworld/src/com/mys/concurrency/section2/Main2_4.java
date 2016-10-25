package com.mys.concurrency.section2;

/**
 * Created by ASUS on 2016/10/26.
 */
public class Main2_4 {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();

        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();

    }
}

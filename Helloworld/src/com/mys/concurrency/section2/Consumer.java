package com.mys.concurrency.section2;

/**
 * 消费者线程类
 * Created by ASUS on 2016/10/26.
 */
public class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            storage.get();
        }
    }
}

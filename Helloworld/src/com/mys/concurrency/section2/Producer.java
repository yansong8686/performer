package com.mys.concurrency.section2;

/**
 * 生产者线程类
 * Created by ASUS on 2016/10/25.
 */
public class Producer implements Runnable{

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            storage.set();
        }
    }
}

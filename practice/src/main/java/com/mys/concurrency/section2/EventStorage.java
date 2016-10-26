package com.mys.concurrency.section2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 模拟生产者-消费者 问题
 * Created by ASUS on 2016/10/25.
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;//缓冲区

    public EventStorage(){
        maxSize = 10;
        storage = new LinkedList<>();
    }

    /**
     * 模拟生产者生产
     */
    public synchronized void set(){
        while (storage.size()==maxSize){//检查缓冲区是不是满的
            try {
                wait();//若满，就挂起线程，并等待空余空间的出现
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //不满，则生产
        storage.add(new Date());
        System.out.printf("Set : %d\n",storage.size());
        notifyAll();//唤醒所有因wait()进入休眠的线程
    }

    /**
     * 模拟消费者消费
     */
    public synchronized void get(){
        while (storage.size()==0){//检查缓冲区是不是空的
            try {
                wait();//若没有，就挂起线程，并等待缓冲区有数据的出现
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //若有数据，则消费
        System.out.printf("===Get : %d : %s\n",storage.size(),((LinkedList<?>)storage).poll());
        notifyAll();//唤醒所有因wait()进入休眠的线程
    }
}

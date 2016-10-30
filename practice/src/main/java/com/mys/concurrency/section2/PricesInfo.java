package com.mys.concurrency.section2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁机制的最大的改造之一：ReadWriteLock接口及其实现类ReentrantReadWriteLock
 * 其有两个锁，1.读操作锁：允许多个线程同时访问
 * 2.写操作锁：只允许一个线程进行操作
 * 即：多线程读操作不互斥，多线程读写互斥，多线程写写互斥
 * Created by manyansong on 2016/10/30.
 */
public class PricesInfo {
    private double  price1;
    private double  price2;
    private ReadWriteLock lock;

    public PricesInfo() {
        this.price1 = 1.0;
        this.price2 = 2.0;
        this.lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        return tRead(lock, price1);
    }

    public double getPrice2() {
        return tRead(lock, price2);
    }

    private static double tRead(ReadWriteLock lock, double price) {
        lock.readLock().lock();//获取读操作锁
//        System.out.printf("读开始。。。price1=%s\n",price);
        double value = price;
//        System.out.printf("读结束。。。price1=%s\n",value);
        lock.readLock().unlock();
        return value;
    }

    public void setPrice(double price1,double price2){
        lock.writeLock().lock();//获取写操作锁
        System.out.printf("old data:price1=%s,prices2=%s\n",this.price1,this.price2);
        System.out.printf("now=%d,写开始。。。\n",System.currentTimeMillis());
        this.price1 = price1;
        this.price2 = price2;
        System.out.printf("now=%d,写结束。。。price1=%s,prices2=%s\n",System.currentTimeMillis(),price1,price2);
        lock.writeLock().unlock();
    }
}

package com.mys.concurrency.section2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ASUS on 2016/10/27.
 */
public class PrintQueue {
//    private final Lock lock = new ReentrantLock();//声明可重入锁
    private final Lock lock = new ReentrantLock(); //参数默认false，不公平锁
//    private final Lock lock = new ReentrantLock(true); //公平锁
    public void printJob(Object document){
//        Lock lock = new ReentrantLock();
        lock.lock();//获取对锁对象的控制

        printJob(lock);
    }

    private static void printJob(Lock lock) {
        try {
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during "+
                    (duration/1000)+" seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//一定要释放，否则会死锁
        }
    }

    public void printJob2(Object document){
//        ReentrantLock queueLock = new ReentrantLock();
        if (lock.tryLock()) {  //如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
            printJob(lock);
        }else {
            //如果lock是局部变量（每个线程是一把锁因此不会有公共的资源需要抢占），就不会走到else语句体
            System.out.println(Thread.currentThread().getName()+"没有获取到锁，生气不打印啦。。。");
        }

    }

    public void printJob3(Object document){

        //公平情况下，操作会排一个队按顺序执行（等待时间最长的优先），来保证执行顺序。
        //不公平情况下，是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队，性能更高。
        ReentrantLock lock = new ReentrantLock(); //参数默认false，不公平锁
//        ReentrantLock lock = new ReentrantLock(true); //公平锁

        lock.lock(); //如果被其它资源锁定，会在此等待锁释放，达到暂停的效果
        printJob(lock);
    }

    public void printJob4(Object document){

        //公平情况下，操作会排一个队按顺序执行，来保证执行顺序。
        //不公平情况下，是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队，性能更高。
//        ReentrantLock lock = new ReentrantLock(); //参数默认false，不公平锁
//        ReentrantLock lock = new ReentrantLock(true); //公平锁
        try{
            if(lock.tryLock(1,TimeUnit.MILLISECONDS)){//如果已经被lock，尝试等待5s，看是否可以获得锁，如果5s后仍然无法获得锁则返回false继续执行
                try {
                    Long duration = (long)(Math.random()*10000);
                    System.out.println(Thread.currentThread().getName()+":aaPrintQueue:Printing a Job during "+
                            (duration/1000)+" seconds");
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                //如果lock是局部变量（每个线程是一把锁因此不会有公共的资源需要抢占），就不会走到else语句体
                System.out.println("都等了5秒了，还没有获取到锁，生气不打印啦。。。");
            }
        }catch (InterruptedException ee){//当前线程被中断时(interrupt)，会抛InterruptedExceptio
            System.out.printf("excepion ee"+ee);
        }
    }

    public void printJob5(Object document){

        //公平情况下，操作会排一个队按顺序执行，来保证执行顺序。
        //不公平情况下，是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队，性能更高。
//        ReentrantLock lock = new ReentrantLock(); //参数默认false，不公平锁
//        ReentrantLock lock = new ReentrantLock(true); //公平锁

        try {
            lock.lockInterruptibly();
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing a Job during "+
                    (duration/1000)+" seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

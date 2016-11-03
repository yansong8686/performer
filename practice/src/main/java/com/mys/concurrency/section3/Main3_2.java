package com.mys.concurrency.section3;

import com.mys.concurrency.section3.Job;

/**
 * 资源的并发访问控制--Semaphore
 * 当启动10个线程时，第一个获得信号量的线程将能够访问临界资源区
 * 其余线程将被信号量阻塞，直到信号量被释放。
 * 一旦信号量被释放，它将选择一个正在等待的线程并允许它访问临界区
 * Created by ASUS on 2016/11/3.
 */
public class Main3_2 {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

package com.mys.concurrency.section3;

import com.mys.concurrency.section3.Job;

/**
 * 资源的并发访问控制--Semaphore
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

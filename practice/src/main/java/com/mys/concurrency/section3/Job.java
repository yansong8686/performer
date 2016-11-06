package com.mys.concurrency.section3;

/**
 * Created by ASUS on 2016/11/3.
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%d %s:Going to print a job\n",System.currentTimeMillis(),Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%d %s:The document has been printed\n",System.currentTimeMillis(),Thread.currentThread().getName());
    }
}

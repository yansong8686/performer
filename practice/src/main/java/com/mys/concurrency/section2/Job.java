package com.mys.concurrency.section2;

/**
 * Created by ASUS on 2016/10/27.
 */
public class Job implements Runnable{
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s:Going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s:The document has been printed\n",Thread.currentThread().getName());
    }
}

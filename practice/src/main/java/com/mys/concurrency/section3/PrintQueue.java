package com.mys.concurrency.section3;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量类Semaphore实现二进制信号量
 * 用来保护对唯一共享资源的访问
 * Created by Jerry on 2016/11/3.
 */
public class PrintQueue {
    private final Semaphore semaphore;//声明一个全局的信号量对象

    public PrintQueue() {
        this.semaphore = new Semaphore(1);//初始化信号量
    }

    /**
     * 模拟文档的打印
     * @param document
     */
    public void printJob(Object document){
        try {
            semaphore.acquire();//获得信号量
            long duration = (long)(Math.random()*10);
            //模拟打印，并等待一段随机时间
            System.out.printf("%d %s:PrintQueue:Printing a job during %d seconds\n",System.currentTimeMillis(),Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();//释放信号量
        }

    }


}

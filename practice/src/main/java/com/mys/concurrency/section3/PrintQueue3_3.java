package com.mys.concurrency.section3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用信号量保护一个资源的多个副本
 * 或者被多个线程同时执行的临界区
 * Created by Jerry on 2016/11/3.
 *
 */
public class PrintQueue3_3 {
    private boolean freePrinters[];
    private Semaphore semaphore;//信号量
    private Lock lockPrinters;//声明一个锁对象，用来保护对freePrinters数组的访问

    public PrintQueue3_3() {
        this.semaphore = new Semaphore(3);//信号量初始化为3
        this.freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }



    /**
     * 模拟文档的打印
     * @param document
     */
    public void printJob(Object document){
        try {
            semaphore.acquire();//获得信号量
            int assigedPrinter = getPrint();
            long duration = (long)(Math.random()*10);
            //模拟打印，并等待一段随机时间
            System.out.printf("%d %s:PrintQueue:Printing a job in Printer %d during %d seconds\n",
                    System.currentTimeMillis(),Thread.currentThread().getName(),assigedPrinter,duration);
            Thread.sleep(duration);
            freePrinters[assigedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();//释放信号量
        }

    }

    //获得分配打印机工作的打印机编号
    private int getPrint() {
        int ret = -1;//存储打印机编号
        try{
            lockPrinters.lock();//获得锁
            for (int i = 0; i < freePrinters.length; i++) {
                if(freePrinters[i]){
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockPrinters.unlock();
        }
        return ret;
    }


}

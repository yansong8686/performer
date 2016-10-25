package com.mys.concurrency.section1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jetty on 2016/10/24.
 */
public class SearchTask1_11 implements Runnable{

    private  Result result;

    public SearchTask1_11(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s:Start\n",name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted \n",name);
            return;
        }
        System.out.printf("Thread %s:End\n",name);
    }

    private void doTask() throws InterruptedException{
        Random random = new Random((new Date()).getTime());
        int value= (int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask1_11 searchTask = new SearchTask1_11(result);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup,searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of Threads:%d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        Thread threads[] = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);//获取线程组中包含的线程列表
        for (int j = 0; j < threadGroup.activeCount(); j++) {
            System.out.printf("Thread %s:%s\n",threads[j].getName(),threads[j].getState());
        }
        waitFinish(threadGroup);
        threadGroup.interrupt();//中断这个组中的其余线程
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

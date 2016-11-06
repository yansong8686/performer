package com.mys.concurrency.section4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 执行通过接收器接收到的每一个任务
 * Created by ASUS on 2016/11/6.
 */
public class Server {
    private ThreadPoolExecutor executor;//声明一个线程池执行器

    public Server() {//初始化线程池执行器
        //通过使用Executor工厂类的newCachedThreadPool()创建一个缓存线程池
        this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(Task task){
        System.out.printf("Server:A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server:Pool size:%d\n",executor.getPoolSize());//返回执行器线程池中实际的线程数
        System.out.printf("Server:Active Count:%d\n",executor.getActiveCount());//正在执行任务的线程数
        System.out.printf("Server:Completed Tasks:%d\n",executor.getCompletedTaskCount());//已经完成的任务数
    }
    public void endServer(){
        executor.shutdown();//需要显示地结束，不然，执行器会继续执行， 程序也不会结束。如果没有任务可以执行，执行器将继续等待新任务的到来，而不是结束执行。
    }
}

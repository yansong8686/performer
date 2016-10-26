package com.mys.concurrency.section1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 使用工厂类ThreadFacotry创建线程
 * Created by ASUS on 2016/10/24.
 */
public class MyThreadFactory1_13  implements ThreadFactory{
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory1_13(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    /**
     * 当实现ThreadFactory接口时，必须覆盖这个方法，大多数基本的线程工厂类只有一行
     * return new Thread(r);
     * @param r
     * @return
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on%s\n",
                t.getId(),t.getName(),new Date()));
        return t;
    }
    public String getStats(){
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while(it.hasNext()){
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

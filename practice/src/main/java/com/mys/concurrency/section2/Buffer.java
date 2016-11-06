package com.mys.concurrency.section2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数据缓冲类，他将被生产者和消费者共享
 * Condition接口提供了挂起线程和唤醒线程的机制
 * Created by ASUS on 2016/10/30.
 */
public class Buffer {
    private LinkedList<String> buffer;//定义缓冲区，用来存放共享数据
    private int maxSize;//用来存放buffer的长度
    private ReentrantLock lock;//用来对修改buffer的代码块进行控制
    private Condition lines;//条件，用来挂起线程和唤醒线程
    private Condition space;
    private boolean pendingLines;//表示缓冲区中是否还有数据

    public void setPendingLines(boolean pendingLines) {//当生产者不再产生新的数据时，线程将调用它
        this.pendingLines = pendingLines;
    }

    /**
     * 初始化Buffer类
     * @param maxSize
     */
    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();//通过Lock.newCondtion()方法创建条件
        space = lock.newCondition();
        pendingLines = true;
    }

    /**
     * 将入参字符串写入缓冲区
     * @param line
     */
    public void insert(String line){
        lock.lock();//获取锁
        try {
            while (buffer.size() == maxSize){//检查缓冲区是否有空位
                space.await();//满了，则调用await()等待空位的出现，当其他线程调用条件space的signal()或signalAll()，此线程会被唤醒
            }
            buffer.offer(line);//有空位后，将数据行保存到缓冲区中
            System.out.printf("nowTime:%d,将入参字符串写入缓冲区,%s:inserted line:%d\n",System.currentTimeMillis(),Thread.currentThread().getName(),buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 返回缓冲区中的第一个字符串
     * @return
     */
    public String get(){
        String line = null;
        lock.lock();
        try {
            while((buffer.size()==0)&&(hasPendingLines())){//检查缓冲区是否有数据行
                lines.await();//数据行空，则调用await()等待缓冲区数据的出现
            }
            if(hasPendingLines()){//有数据
                line = buffer.poll();//获取缓冲区中的第一行
                System.out.printf("nowTime:%d,读取缓冲区中的第一个字符串，%s:Line Readed:%d\n",System.currentTimeMillis(),Thread.currentThread().getName(),buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size()>0;
    }
}

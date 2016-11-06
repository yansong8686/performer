package com.mys.concurrency.section2;

/**
 * 锁中使用多条件
 * Condition的使用，目的是允许线程获取锁并查看等待的某一条件是否满足
 * 如果不满足就挂起（await()）,直到某个线程唤醒（signalAll()）它们
 * Created by ASUS on 2016/10/30.
 */
public class Main2_8 {
    public static void main(String[] args) {
        FileMock mock = new FileMock(100,10);//100行，每行10个字符
        Buffer buffer = new Buffer(20);//长度为20的缓冲区
        Producer2_8 producer = new Producer2_8(mock,buffer);
        Thread threadProducer = new Thread(producer,"Producer");

        Consumer2_8 consumers[] = new Consumer2_8[3];
        Thread threadConsumers[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer2_8(buffer);
            threadConsumers[i] = new Thread(consumers[i],"Consumer"+i);
        }

        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}

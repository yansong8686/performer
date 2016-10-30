package com.mys.concurrency.section2;

/**
 * 读写锁测试类
 * Created by manyansong on 2016/10/30.
 */
public class Main2_6 {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread[] threadsReader = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i]=new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}

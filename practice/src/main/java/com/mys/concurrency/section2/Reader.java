package com.mys.concurrency.section2;

/**
 * 读取类
 * Created by manyansong on 2016/10/30.
 */
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("now=%d,%s:Price 1:%f\n",System.currentTimeMillis(),Thread.currentThread().getName(),pricesInfo.getPrice1());
            System.out.printf("now=%d,%s:Price 2:%f\n",System.currentTimeMillis(),Thread.currentThread().getName(),pricesInfo.getPrice2());
        }
    }
}

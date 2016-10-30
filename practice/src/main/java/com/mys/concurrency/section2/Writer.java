package com.mys.concurrency.section2;

/**
 * 写入类
 * Created by manyansong on 2016/10/30.
 */
public class Writer implements Runnable{
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer : Attempt to modify the price.\n");
            pricesInfo.setPrice(Math.random()*10,Math.random()*8);
            System.out.printf("Writer : prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

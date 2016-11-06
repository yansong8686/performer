package com.mys.concurrency.section2;

import java.util.Random;

/**
 * 消费者类
 * Created by ASUS on 2016/10/30.
 */
public class Consumer2_8 implements Runnable{
    private Buffer buffer;

    public Consumer2_8(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){//如果缓冲区有数据行，则将获取一行并进行处理
            String line = buffer.get();
            processLine(line);
        }
    }

    /**
     * 模拟对数据的处理
     * @param line
     */

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

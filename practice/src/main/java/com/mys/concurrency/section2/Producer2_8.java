package com.mys.concurrency.section2;

/**
 * Created by ASUS on 2016/10/30.
 */
public class Producer2_8 implements Runnable {

    private FileMock mock;
    private Buffer buffer;

    public Producer2_8(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line = mock.getLine();//读取FileMock中的所有数据行
            buffer.insert(line);//将读到的数据行插入缓冲区
        }
        buffer.setPendingLines(false);//通知缓冲区停止生成更多的行
    }
}

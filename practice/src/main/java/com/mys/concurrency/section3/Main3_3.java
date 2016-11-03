package com.mys.concurrency.section3;

/**
 * 最开始调用acquire（）的3个线程将获得对临界区的访问，
 * 其余线程被阻塞。
 * 当一个线程完成了对临界区的访问并释放了信号量，另一个线程将获得这个信号量
 * Created by ASUS on 2016/11/3.
 */
public class Main3_3 {
    public static void main(String[] args) {
        PrintQueue3_3 printQueue = new PrintQueue3_3();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job3_3(printQueue),"Thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

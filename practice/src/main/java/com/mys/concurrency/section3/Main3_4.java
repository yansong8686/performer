package com.mys.concurrency.section3;

/**
 * CountDownLatch实例
 * CountDownLatch机制的特点
 * 1.它不是用来保护共享资源或临界区的，它是用来同步执行多个任务的一个或者多个线程
 * 2.CountDownLatch只允许进入1次，一旦其内部计数器到达0，再调countDown()方法将不起作用
 * 如果要做类似的同步必须要创建一个新呃CountDownLatch对象
 * Created by manyansong on 2016/11/6.
 */
public class Main3_4 {
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);//10表示线程要等待10个先行完成的操作数目
        Thread threadConference = new Thread(conference);
        threadConference.start();
        //创建10个与会者对象，并分别传入线程
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference,"Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

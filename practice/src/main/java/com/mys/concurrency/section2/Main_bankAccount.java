package com.mys.concurrency.section2;

/**
 * Created by manyansong on 2016/11/20.
 */
public class Main_bankAccount {

    public static void main(String[] args) {
        //实现Runnable：所有Thread多线程线程都共享Runnable(接口对象)
        CodeLock target = new CodeLock();
        Thread lq = new Thread(target);
        lq.setName("罗密欧");
        Thread lqwf = new Thread(target);
        lqwf.setName("朱丽叶");
        //调用Thread对象的start()方法,启动线程,执行run()方法(OS)
        lq.start();
        lqwf.start();
    }
}

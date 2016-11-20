package com.mys.concurrency.section2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock锁解决共享资源的并发问题
 * 此线程类实现Runnable接口
 * 线程同步 ：使用ReentrantLock锁，代码编写，实现线程同步
 * ReentrantLock 拥有Synchronized相同的并发性和内存语义(ReentrantLock可实现Synchronized的所有功能,有更精确的线程语义和更好的性能)。<br />
 * synchronized是在JVM层面上实现的,不但可以通过一些监控工具监控synchronized的锁定,而且在代码执行时出现异常,JVM会自动释放锁定；
 * Lock不会自动释放锁,lock是通过代码实现的,要保证锁定一定会被释放,就必须将unlock()放到finally{}中。
 *  适用:在资源竞争不是很激烈的情况下,Synchronized的性能要优于ReetrantLock.
 *  在资源竞争很激烈的情况下，Synchronized的性能会下降几十倍，但是ReetrantLock的性能能维持常态；
 *  Lock在传递锁等锁中，例如"手拉手",更适用。
 * Created by manyansong on 2016/11/20.
 */
public class CodeLock implements Runnable {
    //所有Thread多线程线程都共享Runnable(接口对象)和account对象
    private BankAccount account = new BankAccount();
    //声明锁,jdk1.5
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for(int i = 0; i< 5; i++){           //总共取款5次
            /*makeWithdraw(100);          //每次取款100
            if(account.getBalance() < 0){
                System.out.println("☆"+Thread.currentThread().getName()+"   透支了!");
            }*/
            makeDeposit(1000);//每次存1000

        }
        System.out.println("☆"+Thread.currentThread().getName()+"存完后，余额为："+account.getBalance());
    }

    /**
     * 存款
     * @param amount
     */
    private void makeDeposit(int amount) {
//        lock.lock();
        try {
            int count = 1;//私有变量，没有并发问题存在
            for (int i = 0; i < 20; i++) {
                count++;
            }
            Thread.sleep(1);
            System.out.println(count);
//            System.out.println("☆"+Thread.currentThread().getName()+"   准备存款!");
//            Thread.sleep(1);
//            account.deposit(amount);
//            System.out.println("☆"+Thread.currentThread().getName()+"   完成"+amount+"存款,余额为"+account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }

    /**
     * makeWithdraw 账户取款
     * @param amount 取款金额
     * 打印log记录取款过程
     * */
    private void makeWithdraw(int amount){
        //add lock
//        lock.lock();
        try {
            if(account.getBalance() >= amount){         //如果余额足够则取款
                System.out.println("☆"+Thread.currentThread().getName()+"   准备取款!");
                Thread.sleep(500);
                account.withdraw(amount);
                System.out.println("☆"+Thread.currentThread().getName()+"   完成"+amount+"取款,余额为"+account.getBalance());
            }else{//余额不足则提示
                System.out.println("☆"+"余额不足以支付"+Thread.currentThread().getName()+amount+"   的取款,余额为"+account.getBalance());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"   准备取款,等待0.5s线程中断!"+e.getMessage());
        }finally{
            //release lock must in the finally
//            lock.unlock();
        }
    }
}

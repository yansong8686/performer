package com.mys.concurrency.section2;

/**
 * ReentrantLock锁解决共享资源的并发问题
 * 银行账号类
 * Created by manyansong on 2016/11/18.
 */
public class BankAccount {
    //余额
    private int balance = 500;//全局变量
    //查询
    public int getBalance(){
        return balance;
    }
    //取款
    public void withdraw(int amount){
        balance = balance - amount;
    }
    //存款
    public void deposit(int amount){
        balance = balance + amount;
    }
}

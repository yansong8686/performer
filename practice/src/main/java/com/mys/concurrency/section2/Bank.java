package com.mys.concurrency.section2;

/**
 * Created by ASUS on 2016/10/25.
 */
public class Bank implements Runnable{

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            account.substractAmount(1000);
        }
    }
}

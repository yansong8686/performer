package com.mys.concurrency.section1;

import com.mys.concurrency.section2.Account;

/**
 * Created by ASUS on 2016/10/25.
 */
public class Company implements Runnable{

    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
           account.addAmount(1000);
        }
    }
}

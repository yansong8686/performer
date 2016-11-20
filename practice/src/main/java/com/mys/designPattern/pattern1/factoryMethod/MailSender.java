package com.mys.designPattern.pattern1.factoryMethod;

/**
 * 邮件发送类
 * Created by manyansong on 2016/11/20.
 */
public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("发送邮件。。。");
    }
}

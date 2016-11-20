package com.mys.designPattern.pattern2.abstractFactory;

/**
 * 针对不同的业务功能增加不同的工厂类
 * 解耦合，利于扩展
 * Created by manyansong on 2016/11/21.
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}

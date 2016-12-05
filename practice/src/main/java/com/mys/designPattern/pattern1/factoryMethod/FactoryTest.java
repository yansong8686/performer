package com.mys.designPattern.pattern1.factoryMethod;

/**
 * 1.工厂方法模式
 * Created by manyansong on 2016/11/20.
 */
public class FactoryTest {
    public static void main(String[] args) {
//        SendFactory factory = new SendFactory();
//        Sender sender = factory.produce("sms");//第1种方法
//        Sender sender = factory.produceMail();//第2种方法
        Sender sender = SendFactory.produceMail();//第3种方法
        sender.send();

    }
}

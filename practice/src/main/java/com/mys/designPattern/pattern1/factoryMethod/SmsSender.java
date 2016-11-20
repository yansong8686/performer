package com.mys.designPattern.pattern1.factoryMethod;

/**
 * 短信发送类
 * Created by manyansong on 2016/11/20.
 */
public class SmsSender  implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信。。。");
    }
}

package com.mys.designPattern.pattern2.abstractFactory;

/**
 * Created by manyansong on 2016/11/21.
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

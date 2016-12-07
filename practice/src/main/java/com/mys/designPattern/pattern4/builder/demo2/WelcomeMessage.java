package com.mys.designPattern.pattern4.builder.demo2;

/**
 * 具体产品类--欢迎消息
 * Created by manyansong on 2016/12/7.
 */
public class WelcomeMessage extends AutoMessage{

    public WelcomeMessage() {
        System.out.println("发送欢迎信息...");
    }
}

package com.mys.designPattern.pattern4.builder.demo2;

/**
 * 具体建造者
 * Created by manyansong on 2016/12/7.
 */
public class GoodbyeBuilder extends Builder {

    public GoodbyeBuilder(){
        msg = new GoodbyeMessage();
    }
    @Override
    public void buildBody() {
        msg.setBody("欢送内容");
    }

    @Override
    public void buildSubject() {
        msg.setSubject("欢送标题");
    }

}
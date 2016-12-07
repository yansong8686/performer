package com.mys.designPattern.pattern4.builder.demo2;

/**
 * 具体建造者
 * Created by manyansong on 2016/12/7.
 */
public class WelcomeBuilder extends Builder {
    public WelcomeBuilder(){
        msg = new WelcomeMessage();
    }
    @Override
    public void buildBody() {
        msg.setBody("欢迎内容");
    }

    @Override
    public void buildSubject() {
        msg.setSubject("欢迎标题");
    }

}

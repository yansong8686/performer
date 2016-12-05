package com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass;


/**
 * Created by manyansong on 2016/12/5.
 */
public abstract class AbstractWhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白色人种会哭");
    }

    @Override
    public void cry() {
        System.out.println("白色人种会大笑，侵略的笑声");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话，一般都是但是单字节！");
    }
}

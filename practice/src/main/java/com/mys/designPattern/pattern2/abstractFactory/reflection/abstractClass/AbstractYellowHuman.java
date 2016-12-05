package com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass;

/**
 * 对比工厂方法模型中的YellowHuman类，此处改成抽象类，目的是要定义性别
 * Created by manyansong on 2016/12/5.
 */
public abstract class AbstractYellowHuman implements Human {

    public void laugh() {
        System.out.println("黄色人种会哭");
    }

    public void cry() {
        System.out.println("黄色人种会大笑，幸福呀！");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }
}

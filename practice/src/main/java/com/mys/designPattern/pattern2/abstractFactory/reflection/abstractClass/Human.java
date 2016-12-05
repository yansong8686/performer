package com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass;

/**
 * 定义一个人类的统称,问题出来了，工厂方法模式中，该接口定义的时候忘记定义性别了
 * 需要此处增加该方法，但是这意味着，所以实现了该接口的方法都要修改，违背了开闭原则（OCP）
 * 此时，想到使用抽象类
 * Created by manyansong on 2016/12/5.
 */
public interface Human {
    //人是愉快的，会笑的，本来是想用smile表示，想了一下laugh更合适，好长时间没有大笑了；
    public void laugh();
    //人类还会哭，代表痛苦
    public void cry();
    //人类会说话
    public void talk();
    //定义性别
    public void sex();
}

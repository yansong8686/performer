package com.mys.designPattern.pattern2.abstractFactory;

/**
 * 提供一个接口，抽象出工厂类的公共方法
 * Created by manyansong on 2016/11/21.
 */
public interface Provider {
    public Sender produce();
}

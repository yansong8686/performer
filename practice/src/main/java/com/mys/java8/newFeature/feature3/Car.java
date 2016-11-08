package com.mys.java8.newFeature.feature3;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 多个同名的默认方法示例
 * Created by manyansong on 2016/11/8.
 */
public class Car implements Vehicle,FourWheeler {

    /**
     * 方法一：创建自己的默认方法，覆盖重写接口的默认方法
     */
    /*@Override
    public void print(){
        System.out.println("我是一辆四轮汽车!!!！");
    }*/

    /**
     * 方法二：使用 super 来调用指定接口的默认方法
     */
    @Override
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("XXXXXXXXX");

    }
}

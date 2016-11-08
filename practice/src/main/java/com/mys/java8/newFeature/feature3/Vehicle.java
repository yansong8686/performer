package com.mys.java8.newFeature.feature3;

/**
 *  静态默认方法,ava 8 的另一个特性是接口可以声明（并且可以提供实现）静态方法。
 * Created by manyansong on 2016/11/8.
 */
public interface Vehicle {
    default void print(){
        System.out.println("我是一辆车！");
    }
    //静态默认方法
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}

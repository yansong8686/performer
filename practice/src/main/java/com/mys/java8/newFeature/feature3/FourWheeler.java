package com.mys.java8.newFeature.feature3;

/** 接口的默认方法示例
 * Created by manyansong on 2016/11/8.
 */
public interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车");
    }
}

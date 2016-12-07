package com.mys.designPattern.pattern4.builder.demo1;

/**
 * 抽象建造者
 * Created by manyansong on 2016/12/7.
 */
public interface  Builder {
    public void buildPart1();
    public void buildPart2();
    public Product retrieveResult();
}

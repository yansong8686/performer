package com.mys.designPattern.pattern4.builder.demo1;

/**
 * 具体建造者类
 * Created by manyansong on 2016/12/7.
 */
public class ConcreteBuilder implements Builder{
    private Product product = new Product();
    /**
     * 产品零件建造方法1
     */
    @Override
    public void buildPart1() {
        //构建产品的第一个零件
        product.setPart1("编号：9527");
    }
    /**
     * 产品零件建造方法2
     */
    @Override
    public void buildPart2() {
        //构建产品的第二个零件
        product.setPart2("名称：XXX");
    }
    /**
     * 返回最后组装成品结果 (返回最后装配好的汽车)
     * 成品的组装过程不在这里进行,而是转移到下面的Director类中进行.
     * 从而实现了解耦过程和部件
     */
    @Override
    public Product retrieveResult() {
        return product;
    }
}

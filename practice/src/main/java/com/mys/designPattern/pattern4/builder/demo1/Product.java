package com.mys.designPattern.pattern4.builder.demo1;

/**
 * 产品类
 * Created by manyansong on 2016/12/7.
 */
public class Product {
    /**
     * 定义一些关于产品的操作
     */
    private String part1;
    private String part2;
    public String getPart1() {
        return part1;
    }
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    public String getPart2() {
        return part2;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}

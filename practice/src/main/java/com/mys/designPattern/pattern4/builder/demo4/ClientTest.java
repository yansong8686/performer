package com.mys.designPattern.pattern4.builder.demo4;

/**
 * Created by manyansong on 2016/12/8.
 */
public class ClientTest {
    public static void main(String[] args) {
        Director director = new Director();
        //1W辆A类型的奔驰车
        for(int i=0;i<5;i++){
            director.getABenzModel().run();
            System.out.println("--------------");
        }
        //100W辆B类型的奔驰车
        for(int i=0;i<1;i++){
            director.getBBenzModel().run();
            System.out.println("--------------");
        }
        //1000W量C类型的宝马车
        for(int i=0;i<2;i++){
            director.getCBMWModel().run();
            System.out.println("--------------");
        }
    }
}

//而工厂方法则重点是创建，你要什么对象我创造一个对象出来，组装顺序则不是他关心的

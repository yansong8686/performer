package com.mys.designPattern.pattern5.prototype.demo2;

/**
 * 验证：对象拷贝时，类的构造函数是不会被执行的。
 * Created by manyansong on 2016/12/8.
 */
public class Test {
    public static void main(String[] args) {
        //产生一个对象
        Thing thing = new Thing();
        //拷贝一个对象
        Thing cloneThing = thing.clone();
    }
}

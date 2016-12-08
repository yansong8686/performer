package com.mys.designPattern.pattern5.prototype.demo2;

/**
 * 对象拷贝时确实构造函数没有被执行，这个从原理来讲也是可以讲得通的，Object 类的clone 方法的
 * 原理是从内存中（具体的说就是堆内存）以二进制流的方式进行拷贝，重新分配一个内存块，那构造函数
 * 没有被执行也是非常正常的了。
 * Created by manyansong on 2016/12/8.
 */
public class Thing implements Cloneable{
    public Thing(){
        System.out.println("构造函数被执行了...");
    }
    @Override
    public Thing clone(){
        Thing thing=null;
        try {
            thing = (Thing)super.clone();
            System.out.println("执行clone...");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}

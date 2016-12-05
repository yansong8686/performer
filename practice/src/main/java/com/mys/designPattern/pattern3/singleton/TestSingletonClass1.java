package com.mys.designPattern.pattern3.singleton;

/**
 * 单例模式 -- 方法一 测试
 * 用volatile关键字
 * Created by manyansong on 2016/12/5.
 */
public class TestSingletonClass1 {

    private String name = null;//测试属性
    private volatile static TestSingletonClass1 instance = null;

    public static TestSingletonClass1 getInstance() {
        if (instance == null) {//此处判断，是为了需要进行代码块同步，不为空则不进行代码块同步，提高性能
            synchronized (TestSingletonClass1.class) {
                if(instance == null) {
                    instance = new TestSingletonClass1();
                }
            }
        }
        return instance;
    }

    private TestSingletonClass1() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo(){
        System.out.println("the name is :"+name);
    }

    public static void main(String[] args) {
        TestSingletonClass1 instance1 = TestSingletonClass1.getInstance();
        TestSingletonClass1 instance2 = TestSingletonClass1.getInstance();
        instance2.setName("instatn2");
        instance1.setName("instatn1");

        instance1.printInfo();
        instance2.printInfo();

        if(instance1 == instance2){
            System.out.println("创建的是同一个实例");
        }else{
            System.out.println("创建的不是同一个实例");
        }
        //输出：the name is :instatn1
        //the name is :instatn1
        //创建的是同一个实例
    }
}

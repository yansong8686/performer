package com.mys.designPattern.pattern3.singleton;

/**
 * 单例模式 -- 方法二
 * 使用了Java的静态内部类，不会受到java版本的影响
 * Created by manyansong on 2016/12/5.
 */
public class TestSingletonClass2 {

    private String name = null;//测试属性
    //私有的静态内部类
    private static class SingletonClassInstance {
        private static final TestSingletonClass2 instance = new TestSingletonClass2();
    }

    public static TestSingletonClass2 getInstance() {
        return SingletonClassInstance.instance;
    }

    private TestSingletonClass2() {

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
        TestSingletonClass2 instance1 = TestSingletonClass2.getInstance();
        TestSingletonClass2 instance2 = TestSingletonClass2.getInstance();
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

package com.mys.designPattern.pattern3.singleton;

/**
 * 单例模式 -- 方法二
 * 使用了Java的静态内部类，不会受到java版本的影响
 * SingletonClass2没有static的属性，因此并不会被初始化。直到调用getInstance()的时候，
 * 会首先加载SingletonClassInstance类，这个类有一个static的SingletonClass2实例，
 * 因此需要调用SingletonClass2的构造方法，然后getInstance()将把这个内部类的instance返回给使用者。
 * 由于这个instance是static的，因此并不会构造多次。
 * Created by manyansong on 2016/12/5.
 */
public class SingletonClass2 {

    //私有的静态内部类
    private static class SingletonClassInstance {
        private static final SingletonClass2 instance = new SingletonClass2();
    }

    public static SingletonClass2 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonClass2() {

    }
}

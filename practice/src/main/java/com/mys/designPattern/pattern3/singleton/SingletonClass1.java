package com.mys.designPattern.pattern3.singleton;

/**
 * 单例模式 -- 方法一
 * double---checked----locking 设计实现单例模式
 * 适用于jdk5以后的版本，即使用volatile关键字
 * Created by manyansong on 2016/12/5.
 */
public class SingletonClass1 {

    // 使用volatile的原因：
    // 考虑这么一种情况：线程A开始创建SingletonClass的实例，此时线程B调用了getInstance()方法，
    // 首先判断instance是否为null。按照我们上面所说的内存模型，A已经把instance指向了那块（已经开辟出的）内存，只是还没有调用构造方法进行初始化，
    // 因此B检测到instance不为null，于是直接把instance返回了——问题出现了，尽管instance不为null，但它并没有构造完成，就像一套房子已经给了你钥匙，
    // 但你并不能住进去，因为里面还没有收拾。此时，如果B在A将instance构造完成之前就是用了这个实例，程序就会出现错误了（空指针异常）！
    // volatile 的特性：
    // 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    // 但是没法保证原子性，即没法确保线程安全，还需要加锁
    private volatile static SingletonClass1 instance = null;

    /**
     * 调用 getInstance（）方法，
     * 第一次的时候发现instance时null,然后就创建一个对象，返回出去；
     * 第二次再使用的时候，因为这个instance事static的，共享一个对象变量的，
     * 所以instance的值已经不是null了，因此不会再创建对象，直接将其返回。
     * 这个过程就称为lazy loaded ,也就是迟加载-----直到使用的时候才经行加载。
     * @return
     */
    public static SingletonClass1 getInstance() {
        if (instance == null) {//此处判断，是为了需要进行代码块同步，不为空则不进行代码块同步，提高性能
            synchronized (SingletonClass1.class) {
                if(instance == null) {
                    instance = new SingletonClass1();
                }
            }
        }
        return instance;
    }

    //私有的构造方法，确保能不被new
    private SingletonClass1() {

    }
}

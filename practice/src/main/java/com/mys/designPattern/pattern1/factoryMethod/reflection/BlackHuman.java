package com.mys.designPattern.pattern1.factoryMethod.reflection;

/**
 * Created by manyansong on 2016/11/21.
 */
public class BlackHuman implements Human {
    public void cry() {
        System.out.println("黑人会哭");
    }
    public void laugh() {
        System.out.println("黑人会笑");
    }
    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");
    }
}

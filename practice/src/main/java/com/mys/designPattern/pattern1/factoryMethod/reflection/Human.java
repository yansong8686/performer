package com.mys.designPattern.pattern1.factoryMethod.reflection;

/**
 * 定义一个人类的统称
 * Created by manyansong on 2016/11/21.
 */
public interface Human {
    //人是愉快的，会笑的，本来是想用smile表示，想了一下laugh更合适，好长时间没有大笑了；
    public void laugh();
    //人类还会哭，代表痛苦
    public void cry();
    //人类会说话
    public void talk();
}

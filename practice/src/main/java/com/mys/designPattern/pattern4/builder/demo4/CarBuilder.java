package com.mys.designPattern.pattern4.builder.demo4;

import java.util.ArrayList;

/**
 * Builder模式是把复杂对象的创建和部件的创建分别开来，分别用Builder类和Director类来表示
 * 定义如何创建复杂对象的各个部件
 * Created by manyansong on 2016/12/8.
 */
public abstract class CarBuilder {
    //建造一个模型，你要给我一个顺序要，就是组装顺序
    public abstract void setSequence(ArrayList<String> sequence);
    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}

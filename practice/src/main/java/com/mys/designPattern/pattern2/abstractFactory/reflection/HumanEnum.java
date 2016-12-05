package com.mys.designPattern.pattern2.abstractFactory.reflection;

/**
 * Created by manyansong on 2016/12/5.
 */
public enum HumanEnum {
    //把世界上所有人类型都定义出来
    YelloMaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.YellowMaleHuman"),
    YelloFemaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.YellowFemaleHuman"),
    WhiteFemaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.WhiteFemaleHuman"),
    WhiteMaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.WhiteMaleHuman"),
    BlackFemaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.BlackFemaleHuman"),
    BlackMaleHuman("com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl.BlackMaleHuman");

    private String value = "";
    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}

package com.mys.designPattern.pattern2.abstractFactory.reflection;

import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.Human;
import com.mys.designPattern.pattern2.abstractFactory.reflection.factory.HumanFactory;
import com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.impl.FemaleHumanFactory;
import com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.impl.MaleHumanFactory;

/**
 * 反射+抽象工厂+抽象类
 * 建立起了两条生产线，分别是：男性生产线、女性生产线
 * Created by manyansong on 2016/12/5.
 */
public class Test {
    public static void main(String[] args) {
        //第一条生产线，男性生产线
        HumanFactory maleFactory = new MaleHumanFactory();

        //第二条生产线，女性生产线
        HumanFactory femaleFactory = new FemaleHumanFactory();

        //生产线建立完毕，开始生产人了:
        Human maleYellowHuman = maleFactory.createYellowHuman();

        Human femaleYellowHuman = femaleFactory.createYellowHuman();

        maleYellowHuman.cry();
        maleYellowHuman.laugh();
        femaleYellowHuman.sex();
    }
}

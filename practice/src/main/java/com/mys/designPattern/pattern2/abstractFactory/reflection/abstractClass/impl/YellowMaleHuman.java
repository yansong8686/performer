package com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl;

import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.AbstractYellowHuman;

/**
 * 男性黄种人
 * Created by manyansong on 2016/12/5.
 */
public class YellowMaleHuman extends AbstractYellowHuman {
    public void sex() {
        System.out.println("该黄种人的性别为男....");
    }
}

package com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.impl;

import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.AbstractWhiteHuman;

/**
 * 男性白种人
 * Created by manyansong on 2016/12/5.
 */
public class WhiteMaleHuman extends AbstractWhiteHuman {
    public void sex() {
        System.out.println("该白种人的性别为男....");
    }
}

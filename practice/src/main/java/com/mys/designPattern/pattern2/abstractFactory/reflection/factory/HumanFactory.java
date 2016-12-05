package com.mys.designPattern.pattern2.abstractFactory.reflection.factory;

import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.Human;

/**
 * 这次定一个接口，应该要造不同性别的人，需要不同的生产线
 * Created by manyansong on 2016/12/5.
 */
public interface HumanFactory {
    //制造黄色人种
    public Human createYellowHuman();
    //制造一个白色人种
    public Human createWhiteHuman();
    //制造一个黑色人种
    public Human createBlackHuman();
}

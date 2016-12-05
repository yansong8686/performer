package com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.impl;

import com.mys.designPattern.pattern2.abstractFactory.reflection.HumanEnum;
import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.Human;
import com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.AbstractHumanFactory;

/**
 * 男性创建工厂
 * Created by manyansong on 2016/12/5.
 */
public class MaleHumanFactory extends AbstractHumanFactory {
    /**
     * 创建一个男性黑种人
     * @return
     */
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloMaleHuman);
    }

    /**
     * 创建一个男性白种人
     * @return
     */
    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }

    //创建一个男性黄种人
    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }
}

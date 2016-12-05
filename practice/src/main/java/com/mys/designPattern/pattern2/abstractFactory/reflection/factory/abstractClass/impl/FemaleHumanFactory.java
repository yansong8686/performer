package com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.impl;

import com.mys.designPattern.pattern2.abstractFactory.reflection.HumanEnum;
import com.mys.designPattern.pattern2.abstractFactory.reflection.abstractClass.Human;
import com.mys.designPattern.pattern2.abstractFactory.reflection.factory.abstractClass.AbstractHumanFactory;

/**
 * 女性创建工厂
 * Created by manyansong on 2016/12/5.
 */
public class FemaleHumanFactory extends AbstractHumanFactory {
    /**
     * 创建一个女性黑种人
     * @return
     */
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloFemaleHuman);
    }

    /**
     * 创建一个女性白种人
     * @return
     */
    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }

    //创建一个女性黄种人
    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }
}

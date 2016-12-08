package com.mys.designPattern.pattern4.builder.demo4;

import java.util.ArrayList;

/**
 * Created by manyansong on 2016/12/8.
 */
public class BenzBuilder extends CarBuilder {
    //产品对象
    private BenzModel benz = new BenzModel();
    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }
}

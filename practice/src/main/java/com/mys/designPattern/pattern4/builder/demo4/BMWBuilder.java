package com.mys.designPattern.pattern4.builder.demo4;

import java.util.ArrayList;

/**
 * Created by manyansong on 2016/12/8.
 */
public class BMWBuilder extends CarBuilder{
    private BMWModel bmw = new BMWModel();
    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}

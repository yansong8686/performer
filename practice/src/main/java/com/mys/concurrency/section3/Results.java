package com.mys.concurrency.section3;

/**
 * Created by manyansong on 2016/11/6.
 */
public class Results {
    private int data[];

    public Results(int size) {
        this.data = new int[size];
    }

    public void setData(int position,int value){
        data[position] = value;
    }
    public int[] getData(){
        return data;
    }
}

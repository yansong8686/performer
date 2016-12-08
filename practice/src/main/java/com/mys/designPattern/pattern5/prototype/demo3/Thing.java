package com.mys.designPattern.pattern5.prototype.demo3;

import java.util.ArrayList;

/**
 * 浅拷贝和深拷贝问题
 * 注：Clone 与final 两对冤家。对象的clone 与对象内的final 属性是冲突的
 *
 * Created by manyansong on 2016/12/8.
 */
public class Thing implements Cloneable{

    //定义一个私有变量
    //此变量不能使用final修饰，否则调用clone()报错
    private ArrayList<String> arrayList = new ArrayList<>();

    public Thing(){
        System.out.println("构造函数被执行了...");
    }

    @Override
    public Thing clone(){
        Thing thing=null;
        try {
            //浅拷贝
            thing = (Thing)super.clone();
            //浅拷贝是有风险的，那怎么才能深入的拷贝呢
            //深拷贝
            thing.arrayList = (ArrayList<String>)this.arrayList.clone();
            System.out.println("执行clone...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thing;
    }

    //设置HashMap的值
    public void setValue(String value){
        this.arrayList.add(value);
    }
    //取得arrayList的值
    public ArrayList<String> getValue(){
        return this.arrayList;
    }
}

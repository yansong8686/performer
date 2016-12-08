package com.mys.designPattern.pattern5.prototype.demo1;

/**
 * 广告信的模板
 * 一般都是从数据库取出，生成一个BO 或者是DTO，这里使用一个静态的值来做代表
 * Created by manyansong on 2016/12/8.
 */
public class AdvTemplate {
    //广告信名称
    private String advSubject ="XX银行国庆信用卡抽奖活动";
    //广告信内容
    private String advContext = "国庆抽奖活动通知：只要刷卡就送你1百万！....";
    //取得广告信的名称
    public String getAdvSubject(){
        return this.advSubject;
    }
    //取得广告信的内容
    public String getAdvContext(){
        return this.advContext;
    }
}

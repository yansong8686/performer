package com.mys.designPattern.pattern1.factoryMethod;

/**
 * 发送工厂类
 * Created by manyansong on 2016/11/20.
 */
public class SendFactory {
    //第1种：普通工厂模式
    /*public Sender produce(String type){
        switch (type){
            case "mail":
                return new MailSender();
            case "sms":
                return new SmsSender();
            default:
                System.out.println("请输入正确的类型!");
                return null;
        }
    }*/

    //第2种：多个工厂方法模式
    //针对第1种方法的改进，避免传错字符串，导致不能正确创建对象
    /*public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }*/

    //第3种：静态工厂方法模式
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

}

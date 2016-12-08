package com.mys.designPattern.pattern5.prototype.demo1;

import java.util.Random;

/**
 * 原型模式
 * 同ClientTest1，本例一样完成了电子广告信的发送功能，而且sendMail 即使是多线程也没有关系，看到mail.clone()这个方法了吗？
 * 把对象拷贝一份，产生一个新的对象，和原有对象一样，然后再修改细节的
 * 数据，如设置称谓，设置收件人地址等等。这种不通过new 关键字来产生一个对象，而是通过对象拷贝来
 * 实现的模式就叫做原型模式。
 * Created by manyansong on 2016/12/8.
 */

/**
 * 原型模式适合在什么场景使用？一是类初始化需要消化非常多的资源，这个资源包括数据、硬件资源
 等；二是通过new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式；三是一个对
 象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对
 象供调用者使用。在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone
 的方法创建一个对象，然后由工厂方法提供给调用者。
 *
 */
public class ClientTest2 {
    static int MAX_COUNT = 6;
    public static void main(String[] args) {
        //模拟发送邮件
        int i=0;
        //把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while(i<MAX_COUNT){
            //以下是每封邮件不同的地方
            Mail cloneMail = mail.clone();//此处与ClientTest1不同
            cloneMail.setAppellation(getRandString(5)+" 先生（女士）");
            cloneMail.setReceiver(getRandString(5) + "@" + getRandString(8)+".com");
            //然后发送邮件
            sendMail(cloneMail);
            i++;
        }
    }
    //发送邮件
    public static void sendMail(Mail mail){
        System.out.println("标题："+mail.getSubject() + "\t收件人："+mail.getReceiver()+"\t....发送成功");
    }
    //获得指定长度的随机字符串
    public static String getRandString(int maxLength){
        String source ="abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for(int i=0;i<maxLength;i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}

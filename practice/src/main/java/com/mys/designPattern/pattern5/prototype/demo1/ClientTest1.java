package com.mys.designPattern.pattern5.prototype.demo1;

import java.util.Random;

/**
 * Created by manyansong on 2016/12/8.
 */
public class ClientTest1 {
    static int MAX_COUNT = 6;
    public static void main(String[] args) {
        //模拟发送邮件
        int i=0;
        //把模板定义出来，这个是从数据库中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        while(i<MAX_COUNT){
            //以下是每封邮件不同的地方
            mail.setAppellation(getRandString(5)+" 先生（女士）");
            mail.setReceiver(getRandString(5) + "@" + getRandString(8)+".com");
            //然后发送邮件
            sendMail(mail);
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

package com.mys.designPattern.pattern4.builder.demo2;

import java.util.Date;

/**
 * 产品抽象类
 * 本例虽然存在一个共同的接口，但是仅仅是本例，并不代表建造模式的特点
 * 标准的建造模式里面，一般是不需要对产品定义抽象接口的，因为最终构造的产品千差万别，给这些产品定义公共接口几乎是没有意义的。
 * Created by manyansong on 2016/12/7.
 */
public abstract class AutoMessage {
    //收件人地址
    private String to;
    //发件人地址
    private String from;
    //标题
    private String subject;
    //内容
    private String body;
    //发送日期
    private Date sendDate;

    /**
     * 模拟发送类
     */
    public void send(){
        System.out.println("收件人地址：" + to);
        System.out.println("发件人地址：" + from);
        System.out.println("标题：" + subject);
        System.out.println("内容：" + body);
        System.out.println("发送日期：" + sendDate);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}

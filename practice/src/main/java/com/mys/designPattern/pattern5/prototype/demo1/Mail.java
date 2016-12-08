package com.mys.designPattern.pattern5.prototype.demo1;

/**
 * 业务对象--邮件类
 * Java 提供了一个Cloneable 接口
 * 来标示这个对象是可拷贝的，为什么说是“标示”呢？翻开JDK 的帮助看看Cloneable 是一个方法都没有
 * 的，这个接口只是一个标记作用，在JVM 中具有这个标记的对象才有可能被拷贝，那怎么才能从“有可能
 * 被拷贝”转换为“可以被拷贝”呢？方法是覆盖clone()方法，是的，你没有看错是重写clone()方法，
 * Created by manyansong on 2016/12/8.
 */
public class Mail implements Cloneable{
    //收件人
    private String receiver;
    //邮件名称
    private String subject;
    //称谓
    private String appellation;
    //邮件内容
    private String contxt;
    //邮件的尾部，一般都是加上“XXX版权所有”等信息
    private String tail;
    //构造函数
    //对象拷贝时，类的构造函数是不会被执行的。
    public Mail(AdvTemplate advTemplate){
        this.contxt = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }
    //以下为getter/setter方法
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getAppellation() {
        return appellation;
    }
    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
    public String getContxt() {
        return contxt;
    }
    public void setContxt(String contxt) {
        this.contxt = contxt;
    }
    public String getTail() {
        return tail;
    }
    public void setTail(String tail) {
        this.tail = tail;
    }

    /**
     * 对对象进行拷贝
     * 对象拷贝时，类的构造函数是不会被执行的。
     * @return
     */
    @Override
    protected Mail clone() {
        Mail mail =null;
        try {
            mail = (Mail)super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mail;
    }

}

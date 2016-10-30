package com.mys.concurrency.section2;

/**
 * 文本文件模拟器
 * Created by ASUS on 2016/10/30.
 */
public class FileMock {
    private String content[];//存储文件内容
    private int index;//表示要从这个文件读取的内容的行号

    public FileMock(int size,int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                buffer.append((char)indice);//随机字符串
            }
            content[i] = buffer.toString();
        }
        index = 0;//从第0行开始读
    }

    /**
     * 如果文件中有可处理的数据行，则返回true;
     * 如果已经到达模拟文件的结尾，则返回false
     * @return
     */
    public boolean hasMoreLines(){
        return index<content.length;
    }

    /**
     * 返回属性index指定行内容，并且将index自动增加1
     * @return
     */
    public String getLine(){
        if(this.hasMoreLines()){
            System.out.println("nowTime:"+System.currentTimeMillis()+"Mock:"+(content.length-index));
            return content[index++];
        }
        return null;
    }
}

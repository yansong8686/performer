package com.mys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 表达式:
 * 是一种匿名函数，但在Java中，Lambda表达式是对象，他们必须依附于一类特别的对象类型——函数式接口(functional interface)
 * 简单地说，它是没有声明的方法，也即没有访问修饰符、返回值声明和名字。
 * 可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 * 语法格式:(parameters) -> expression 或 (parameters) ->{ statements; }
 * 示例：
 * //旧方法:
 *  new Thread(new Runnable() {
 * @Override
 * public void run() {
 * System.out.println("Hello from thread");
 * }
 * }).start();

 *  //新方法:
 *  new Thread(
 * () -> System.out.println("Hello from thread")
 * ).start();
 * Created by manyansong on 2016/11/7.
 */

/**
 * 函数式接口:
 */
public class LambdaTest1 {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Tester tester = new Java8Tester();
        System.out.println("使用 Java 7 语法: ");

        sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");

        sortUsingJava8(names2);
        System.out.println(names2);
    }

    // 使用 java 7 排序
    private static void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private static void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}


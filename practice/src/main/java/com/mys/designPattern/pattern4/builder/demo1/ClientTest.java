package com.mys.designPattern.pattern4.builder.demo1;

/**
 * 客户端测试类
 * Created by manyansong on 2016/12/7.
 */
/**
 * 建造模式涉及到四个角色：
 * 1、抽象建造者（Builder）:给出一个抽象接口，以规范产品对象的各个组成成分的建造。一般而言，此接口独立于应用程序的商业逻辑。模式中直接创建产品对象的是具体建造者 (ConcreteBuilder)角色。
 * 一般来说，产品所包含的零件数目与建造方法的数目相符。换言之，有多少 零件，就有多少相应的建造方法。
 * 2、具体建造者（ConcreteBuilder）：担任这个角色的是与应用程序紧密相关的一些类，它们在应用程序调用下创建产品的实例。这个角色要完成的任务包括：
 *  a.实现抽象建造者Builder所声明的接口，给出一步一步地完成创建产品实例的操作。b.在建造过程完成后，提供产品的实例。
 * 3、导演者（Director）：担任这个角色的类调用具体建造者角色以创建产品对象。应当指出的是，导演者角色并没有产品类的具体知识，真正拥有产品类的具体知识的是具体建造者角色。
 * 4、产品（Product）：产品便是建造中的复杂对象。一般来说，一个系统中会有多于一个的产品类，而且这些产品类并不一定有共同的接口，而完全可以是不相关联的。
 */
public class ClientTest {
    public static void main(String[]args){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}

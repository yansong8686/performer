package com.mys.designPattern.pattern4.builder.demo3;

/**
 * 客户端测试类
 * Created by manyansong on 2016/12/7.
 */
public class ClientTest {
    public static void main(String[]args){
        //创建构建器对象
        InsuranceContract.ConcreteBuilder builder =
                new InsuranceContract.ConcreteBuilder("9527", 123L, 456L);
        //设置需要的数据，然后构建保险合同对象
        InsuranceContract contract =
                builder.setPersonName("小明").setOtherData("test").build();
        //操作保险合同对象的方法
        contract.someOperation();
    }
}

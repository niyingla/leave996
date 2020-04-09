package com.imooc.zhangxiaoxi.lombok;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @Getter注解
 * 为属性生成get方法
 */
public class GetterTest {

    @Getter(
        lazy = true //第一次调用时加载数据 以后都不执行
    )
    private final String field1 = set111();

    @Getter(
            value = AccessLevel.PRIVATE, //方法私有
            onMethod_={@NotNull} //在方法上加这个注解
    )
    private String field2;

    public String set111(){
        System.out.println(111);
        return "sahds";
    }

    public static void main(String[] args) throws Exception{
        GetterTest getterTest = new GetterTest();
        String field1 = getterTest.getField1();
        String field2 = getterTest.getField1();
        String field3 = getterTest.getField1();
        System.out.println(field3);
    }

}

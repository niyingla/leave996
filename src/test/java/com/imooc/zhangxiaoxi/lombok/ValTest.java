package com.imooc.zhangxiaoxi.lombok;

import lombok.val;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @val注解
 * 弱语言变量
 */
public class ValTest {

    public ValTest() {
        val field = "zhangxiaoxi";

        val list = new ArrayList<String>();
        list.add("zhangxiaoxi");
        System.out.println(list);
    }

    @Test
    public void ValTest() {
        val field = "zhangxiaoxi";

        val list = new ArrayList<String>();
        list.add("zhangxiaoxi2");
        list.add(field);
        System.out.println(list);
    }


}

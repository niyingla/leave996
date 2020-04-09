package com.imooc.zhangxiaoxi.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @AllArgsConstructor 全参构造
 * @NoArgsConstructor 无参构造
 * @RequiredArgsConstructor 必需要参数的构造 比如final，@NonNull
 */
@RequiredArgsConstructor
public class ConstructorTest {

    /**
     * final 入参需要再创建传入
     */
    private final String field1;

    /**
     *
     */
    @NonNull
    private String field2;

    private String field3;

}

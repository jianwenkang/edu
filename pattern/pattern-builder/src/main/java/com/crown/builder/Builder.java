package com.crown.builder;

/**
 * @ClassName Builder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-22
 * @Time 11:39
 * @Version 1.0
 */
public interface Builder {

    void buildPart1();

    void buildPart2();

    Product retrieveResult();
}

package com.crown.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestExe
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/29
 * @Time 11:03
 * @Version 1.0
 */
public class TestExe {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

    }
}

package com.crown.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ListenerTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/23
 * @Time 14:56
 * @Version 1.0
 */
public class ListenerTest {
    public static void main(String[] args) {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:conf/spring-listener.xml");
    }
}

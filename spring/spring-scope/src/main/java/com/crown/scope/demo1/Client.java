package com.crown.scope.demo1;

import com.crown.scope.demo1.service.ScopeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/11
 * @Time 15:20
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/conf/spring.xml");

        new Thread(()->{
            ScopeService scopeService = context.getBean(ScopeService.class);
            scopeService.say(context);
        }).start();

        new Thread(()->{
            ScopeService scopeService = context.getBean(ScopeService.class);
            scopeService.say(context);
        }).start();
    }
}

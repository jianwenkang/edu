package com.crown.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/23
 * @Time 14:45
 * @Version 1.0
 */
public class MyApplicationListener implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("ApplicationListener");
        logger.debug("{}","ApplicationListener");
    }
}

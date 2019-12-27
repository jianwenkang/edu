package com.crown.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @ClassName MyBean0
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/23
 * @Time 14:46
 * @Version 1.0
 */
public class MyBean1 implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(MyBean1.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("{}:{}","MyBean1","InitializingBean");
    }

    @PostConstruct
    public void postConstruct(){
        logger.debug("{}:{}","MyBean1","@PostConstruct");
    }
}

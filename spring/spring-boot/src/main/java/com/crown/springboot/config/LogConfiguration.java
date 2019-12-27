package com.crown.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName LogConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/25
 * @Time 15:27
 * @Version 1.0
 */
@Configuration
public class LogConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfiguration.class);

    @Bean
    public Object logMethod() {
        LOG.info("==========print log==========");
        return new Object();
    }

}

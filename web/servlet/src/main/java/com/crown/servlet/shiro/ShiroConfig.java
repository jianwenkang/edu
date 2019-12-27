package com.crown.servlet.shiro;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ClassName ShiroConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 15:09
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages="com.crown.servlet.shiro",
        includeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class))
public class ShiroConfig {

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        return defaultWebSecurityManager;
    }
}

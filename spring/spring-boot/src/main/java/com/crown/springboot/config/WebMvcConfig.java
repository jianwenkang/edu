package com.crown.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:07
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {



    @Override

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");

    }

}

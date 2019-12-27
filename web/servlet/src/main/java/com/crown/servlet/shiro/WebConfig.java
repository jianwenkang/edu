package com.crown.servlet.shiro;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:49
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages="com.crown.servlet.shiro",
        includeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class),useDefaultFilters=false)
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/shiro/", ".jsp");
    }

    //静态资源配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**")
                .addResourceLocations("/img/")
                .setCachePeriod(31556926);
    }


    /**
     * 启动 shiro 注解
     *  【注意】
     *  1. 因为配置的是 父子 容器，所以如果要在@Controller标注的类下使用shiro注解
     *      必须将以下配置配置到子容器中来，否者父容器初始化时只扫描shiro注解而不扫描@Controller
     *      就会出现shiro注解不生效的情况；
     *
     *  2.所以如果在@Controller标注的类下使用shiro注解，必须是@Controller和shiro注解同时被扫描才是
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator bean = new DefaultAdvisorAutoProxyCreator();
        bean.setProxyTargetClass(true);
        return bean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor bean = new AuthorizationAttributeSourceAdvisor();
        bean.setSecurityManager(securityManager);
        return bean;
    }

}

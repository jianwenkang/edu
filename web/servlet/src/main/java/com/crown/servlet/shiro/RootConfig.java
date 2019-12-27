package com.crown.servlet.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RootConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:49
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages="com.crown.servlet.shiro",
        includeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class))
public class RootConfig {

    /** shiro bean */

//  @Bean
//  public EhCacheManager ehcacheManager() {
//      EhCacheManager bean = new EhCacheManager();
//      bean.setCacheManagerConfigFile("classpath:ehcache.xml");
//      return bean;
//  }

    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager(
            UserAuthorizingRealm userAuthorizingRealm/*,
            EhCacheManager ehCacheManager*/) {

        DefaultWebSecurityManager bean = new DefaultWebSecurityManager();

        bean.setRealm(userAuthorizingRealm); //自定义realm
//      bean.setCacheManager(ehCacheManager);
//      bean.setSessionManager(sessionManager);

        return bean;
    }

    @Bean(name= "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager,
                                              UserFormAuthenticationFilter userFormAuthenticationFilter,
                                              LogoutFilter logoutFilter) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        bean.setSecurityManager(securityManager);
        bean.setLoginUrl("/user/login"); //表单登录URL
        bean.setSuccessUrl("/login_success.jsp"); //认证成功跳转到的URL
        bean.setUnauthorizedUrl("/login"); //受权失败调转到的URL

        //自定义拦截器
        Map<String, javax.servlet.Filter> filters = new HashMap<>();
        userFormAuthenticationFilter.setUsernameParam("myusername");
        userFormAuthenticationFilter.setPasswordParam("mypassword");
        filters.put("formFilter", userFormAuthenticationFilter);
        filters.put("userLogout", logoutFilter);
        bean.setFilters(filters);

        //url拦截配置
        Map<String, String> map = new HashMap<>();
        //map.put("/", "anon");
        map.put("/index", "anon");
        map.put("/login", "anon"); //登录页面,不能省略该配置
        map.put("/user/logout", "userLogout"); //登出

        map.put("/user/login", "formFilter"); //登录认证
        map.put("/**", "formFilter");
        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/user/login");
        return bean;
    }

    @Bean
    public LogoutFilter logoutFilter() {
        LogoutFilter bean = new LogoutFilter();
        bean.setRedirectUrl("/login");
        return bean;
    }


}

package com.crown.springboot.config;

import com.crown.springboot.service.CustomUserService;
import com.crown.springboot.service.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:07
 * @Version 1.0
 */
@Configuration

@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;


    @Autowired
    private CustomUserService customUserService;





    @Override

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserService); //user Details Service验证



    }



    @Override

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .anyRequest().authenticated() //任何请求,登录后可以访问

                .and()

                .formLogin()

                .loginPage("/login")

                .failureUrl("/login?error")

                .permitAll() //登录页面用户任意访问

                .and()

                .logout().permitAll(); //注销行为任意访问

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)

                .csrf().disable();





    }

}

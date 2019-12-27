package com.crown.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName SpringSecurityConfiguration
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/16
 * @Time 11:01
 * @Version 1.0
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //登陆
            .formLogin()
                .loginPage("/")//自定义用户登入页面
                .loginProcessingUrl("/login")
                .usernameParameter("myusername")
                .passwordParameter("mypassword")
                .successForwardUrl("/th/home")
                .failureUrl("/")// 自定义登入失败页面，前端可以通过url中是否有error来提供友好的用户登入提示
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/mylogout")// 自定义用户登出页面
                .logoutSuccessUrl("/")
                .permitAll()
            .and()
            //
            .authorizeRequests()
            //.antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()  // 允许访问资源
            .antMatchers("/").permitAll() //允许访问这三个路由
            .antMatchers("/admin").hasRole("ADMIN")   // 满足该条件下的路由需要ROLE_ADMIN的角色
            .antMatchers("/user").hasRole("USER")     // 满足该条件下的路由需要ROLE_USER的角色
            .anyRequest().authenticated()
            .and()

            .logout().logoutUrl("/logout")
            .permitAll()
            .and()
            //.exceptionHandling().accessDeniedHandler(accessDeniedHandler).and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //基于内存来存储用户信息  inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("USER").and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("456")).roles("ADMIN");


    }
}

package com.crown.springbootsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * @ClassName SpringSecurityConfiguration
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/23
 * @Time 17:24
 * @Version 1.0
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService myUserDetailsService;

    @Autowired
    private PasswordEncoder myPasswordEncoder;

    @Autowired
    private AccessDecisionManager myAccessDecisionManager;

    @Autowired
    private FilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/none/pagea","/none/pageb").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login.html")//登录页面
                .usernameParameter("myusername")
                .passwordParameter("mypassword")
                .loginProcessingUrl("/mylogin")//登录页面表单提交地址，此地址可以不真实存在。
                .successForwardUrl("/")//登录成功后跳转地址
                .permitAll()     // 允许
                ;
        //关闭csrf防护，类似于防火墙，不关闭上面的设置不会真正生效。
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //基于内存来存储用户信息
		/*auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER").and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN", "USER");*/
		auth.userDetailsService(myUserDetailsService).passwordEncoder(myPasswordEncoder);
    }
}

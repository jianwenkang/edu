package com.crown.springbootsecurity.configuration;

import com.crown.springbootsecurity.service.security.MyAuthenticationProvider;
import com.crown.springbootsecurity.service.security.MyAuthenticationSuccessHandler;
import com.crown.springbootsecurity.service.security.MyFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @ClassName SpringSecurityConfiguration
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/23
 * @Time 17:24
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDecisionManager myAccessDecisionManager;

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private FilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/none/pagea","/none/pageb").permitAll()
                /*.antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")*/
         //       .anyRequest().authenticated()
        ;
        http.formLogin()
                .loginPage("/login.html")//登录页面
                .usernameParameter("myusername")
                .passwordParameter("mypassword")
                .loginProcessingUrl("/mylogin")//登录页面表单提交地址，此地址可以不真实存在。
                //.successForwardUrl("/")//登录成功后跳转地址
                .successHandler(myAuthenticationSuccessHandler)
                //.failureForwardUrl("/login.html")
                .failureHandler(myAuthenticationFailureHandler)
                .permitAll()     // 允许
                ;
        http.logout()
                .logoutUrl("/mylogout")// 自定义用户登出页面
                .logoutSuccessUrl("/")
                //.logoutSuccessHandler()
                .permitAll();
        //关闭csrf防护，类似于防火墙，不关闭上面的设置不会真正生效。
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //基于内存来存储用户信息
		/*auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("USER").and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN", "USER");*/
		//auth.userDetailsService(myUserDetailsService).passwordEncoder(myPasswordEncoder);
		auth.authenticationProvider(myAuthenticationProvider);
    }

    @Bean
    public RoleVoter grantedAuthorityDefaults() {

        RoleVoter roleVoter = new RoleVoter();
        roleVoter.setRolePrefix("");
        return roleVoter;
    }

}

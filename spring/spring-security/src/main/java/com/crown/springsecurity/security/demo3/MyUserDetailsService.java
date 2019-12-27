package com.crown.springsecurity.security.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/20
 * @Time 16:50
 * @Version 1.0
 */
@Component("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
    /**
     * @param username 前台提交的用户名
     * @return  封装数据库中与用户相关的信息 eg：用户名，密码，角色。。。
     * @throws UsernameNotFoundException  查询失败抛出异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据前台的用户名去数据库查询用户相关信息
        logger.debug("{}:{}","模拟查询数据库",username);
        String role = "ROLE_USER";
        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        UserDetails userDetails = new User(username, "aaa(00000000)", grantedAuthorities);
        UserDetails userDetails1 = new MyUser(username, "123", grantedAuthorities, "kjh");
        return userDetails1;
    }
}

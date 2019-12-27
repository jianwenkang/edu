package com.crown.springsecurity.security.demo2;

import com.crown.springsecurity.util.EncoderUtil;
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
        if(username.endsWith("ccc")) throw new UsernameNotFoundException("查询失败");
        String pw = "123";
        String saltValue = username;
        String role = "ROLE_USER";
        //pw = EncoderUtil.md5Encoder(pw + "_" + username);//返回加密后的密码  数据保存的应为加密后的密文  正常逻辑位在注册时加密密码在此处直接返回
        pw = EncoderUtil.md5Encoder(pw+"{"+saltValue+"}");//spring security 拼接方式
        //grantedAuthorities  用户的角色信息
        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        UserDetails userDetails = new User(username,pw, grantedAuthorities);
        return userDetails;
    }
}

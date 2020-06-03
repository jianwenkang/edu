package com.crown.springbootsecurity.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName MyAuthenticationProvider
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-01
 * @Time 16:50
 * @Version 1.0
 */
@Service
public class MyAuthenticationProvider implements AuthenticationProvider {
    private static Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);
    @Autowired
    private UserDetailsService myUserDetailsService;

    @Autowired
    private PasswordEncoder myPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        // 这里构建来判断用户是否存在和密码是否正确
        //UserInfo userInfo = (UserInfo) myUserDetailsService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
        UserDetails userInfo = myUserDetailsService.loadUserByUsername(userName);// 这里调用我们的自己写的获取用户的方法；
        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        boolean matches = myPasswordEncoder.matches(password, userInfo.getPassword());
        if(matches){
            logger.info("密码正确");
        }else {
            logger.info("密码错误");
            throw new BadCredentialsException("密码不正确");
        }
        // //这里还可以加一些其他信息的判断，比如用户账号已停用等判断，这里为了方便我接下去的判断，我就不用加密了。
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

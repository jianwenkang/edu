package com.crown.springsecurity.security.demo3;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/21
 * @Time 9:55
 * @Version 1.0
 */
@Component("mySaltSource")
public class MySaltSource implements SaltSource {
    @Override
    public Object getSalt(UserDetails userDetails) {
        MyUser myUser = (MyUser) userDetails;
        return myUser.getMySaltValue();
    }
}

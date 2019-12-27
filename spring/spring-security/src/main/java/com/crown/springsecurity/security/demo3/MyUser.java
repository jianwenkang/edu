package com.crown.springsecurity.security.demo3;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/21
 * @Time 9:44
 * @Version 1.0
 */
public class MyUser extends User {
    private String mySaltValue;

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String mySaltValue) {
        super(username, password, authorities);
        this.mySaltValue = mySaltValue;
    }

    public String getMySaltValue() {
        return mySaltValue;
    }
}

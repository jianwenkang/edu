package com.crown.springbootsecurity.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ClassName MyPasswordEncoder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 16:59
 * @Version 1.0
 */

@Service
public class MyPasswordEncoder extends BCryptPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence clientPassword) {
        String encodedPassword = new BCryptPasswordEncoder().encode(clientPassword);
        return encodedPassword;
    }

    @Override
    public boolean matches(CharSequence clientPassword, String encodedPassword) {
        encode(clientPassword);
        boolean matches = new BCryptPasswordEncoder().matches(clientPassword, encodedPassword);
        return true;
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}

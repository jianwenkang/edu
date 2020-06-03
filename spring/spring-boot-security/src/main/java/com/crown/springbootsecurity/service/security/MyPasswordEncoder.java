package com.crown.springbootsecurity.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(MyPasswordEncoder.class);

    @Override
    public String encode(CharSequence clientPassword) {
        String encodedPassword = new BCryptPasswordEncoder().encode(clientPassword);
        return encodedPassword;
    }

    @Override
    public boolean matches(CharSequence clientPassword, String encodedPassword) {
        encode(clientPassword);
        boolean matches = new BCryptPasswordEncoder().matches(clientPassword, encodedPassword);
        logger.info("密码对比结果:{}",matches);
        return matches;
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}

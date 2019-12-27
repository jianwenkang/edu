package com.crown.springsecurity.security.demo3;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/20
 * @Time 19:20
 * @Version 1.0
 */
@Component("myPasswordEncoder")
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     *  再次方法中书写自己的加密算法  spring security不会调用
     * @param clientPw 客户端的明文密码
     * @param saltValue 盐
     * @return  返回加密后的结果
     */
    @Override
    public String encodePassword(String clientPw, Object saltValue) {
        return clientPw + saltValue;
    }

    /**
     * 对比密码是否一直
     * @param dbpw   前台明文密码
     * @param clientpw      数据库密码
     * @param saltValue 盐
     * @return
     */
    @Override
    public boolean isPasswordValid(String dbpw, String clientpw, Object saltValue) {
        String encoderpw = encodePassword(clientpw,saltValue);
        return encoderpw.equals(dbpw);
    }
}

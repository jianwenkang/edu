package com.crown.shiro.web.realms;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @ClassName CredentialsMatcher
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/6
 * @Time 11:52
 * @Version 1.0
 */
public class MyCredentialsMatcher implements CredentialsMatcher {

    //自定义加密规则

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        return true;
    }
}

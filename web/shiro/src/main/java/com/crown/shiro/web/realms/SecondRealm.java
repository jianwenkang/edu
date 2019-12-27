package com.crown.shiro.web.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName SecondRealm
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/5
 * @Time 19:15
 * @Version 1.0
 */
public class SecondRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        System.out.println("[SecondReaml] doGetAuthenticationInfo");

        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String username = upToken.getUsername();

        System.out.println("Second从数据库中获取 username: " + username + " 所对应的用户信息.");

        if("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在! ");
        }


        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }

        Object principal = username;
        //2). credentials: 密码.
        Object credentials = null; //"fc1709d0a95a6be30bc5926fdb7f22f4";
        if("admin".equals(username)){
            credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
        }else if("user".equals(username)){
            credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
        }

        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
        info = new SimpleAuthenticationInfo("secondRealmName", credentials, credentialsSalt, realmName);
        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "SHA1";
        Object credentials = "123456";
        Object salt = ByteSource.Util.bytes("admin");;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
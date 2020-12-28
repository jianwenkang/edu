package com.crown.mail.madong;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @ClassName MyAuthenticator
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-11-02
 * @Time 13:34
 * @Version 1.0
 */
public class MyAuthenticator extends Authenticator {
    String userName=null;
    String password=null;

    public MyAuthenticator( ) {

    }
    public MyAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);

    }
}

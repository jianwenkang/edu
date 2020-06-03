package com.crown.springboot.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @ClassName MyGrantedAuthority
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:14
 * @Version 1.0
 */
public class MyGrantedAuthority implements GrantedAuthority {



    private String url;

    private String method;



    public String getPermissionUrl() {

        return url;

    }



    public void setPermissionUrl(String permissionUrl) {

        this.url = permissionUrl;

    }



    public String getMethod() {

        return method;

    }



    public void setMethod(String method) {

        this.method = method;

    }



    public MyGrantedAuthority(String url, String method) {

        this.url = url;

        this.method = method;

    }



    @Override

    public String getAuthority() {

        return this.url + ";" + this.method;

    }

}

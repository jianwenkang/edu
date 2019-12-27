package com.crown.mybatis.demo1.entity;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:32
 * @Version 1.0
 */
public class User {
    private Integer userId;

    private String userName;

    private Address address;

    private List<Phnoe> phnoes;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address=" + address +
                ", phnoes=" + phnoes +
                '}';
    }

    public List<Phnoe> getPhnoes() {
        return phnoes;
    }

    public void setPhnoes(List<Phnoe> phnoes) {
        this.phnoes = phnoes;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

package com.crown.mybatis.demo2.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 10:47
 * @Version 1.0
 */
public class User {
    private Integer userId;

    private String userName;

    private String userSex;

    public User(Integer userId, String userName, String userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}

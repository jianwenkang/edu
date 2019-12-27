package com.crown.springboot.entity;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/12
 * @Time 16:51
 * @Version 1.0
 */
public class User {

    private String name;

    private Integer age;

    private String password;

    private Date Birthday;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", Birthday=" + Birthday +
                ", desc='" + desc + '\'' +
                '}';
    }
}

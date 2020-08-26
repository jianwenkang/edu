package com.crown.myrmi;

import java.io.IOException;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 17:36
 * @Version 1.0
 */
public class User {

    private int age;

    public int getAge() throws IOException {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}

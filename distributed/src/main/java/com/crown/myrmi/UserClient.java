package com.crown.myrmi;

import java.io.IOException;

/**
 * @ClassName UserClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 17:49
 * @Version 1.0
 */
public class UserClient {
    public static void main(String[] args) throws IOException {
        User user = new UserStub();
        int age = user.getAge();

        System.out.println(age);
    }
}

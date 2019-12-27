package com.crown.distributed.rmi.demo;

import java.io.IOException;

/**
 * Created by Crown on 2019/1/30.
 */
public class UserClient {
    public static void main(String[] args) throws IOException {
        User_Stub user = new User_Stub();
        int age = user.getAge();
        System.out.println(age);
    }
}

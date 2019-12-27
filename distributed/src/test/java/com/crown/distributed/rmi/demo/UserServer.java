package com.crown.distributed.rmi.demo;

/**
 * Created by Crown on 2019/1/30.
 */
public class UserServer extends User{
    public static void main(String[] args) {
        UserServer userServer = new UserServer();
        userServer.setAge(18);
        User_Skeeleton user_skeeleton = new User_Skeeleton(userServer);
        user_skeeleton.start();
    }
}

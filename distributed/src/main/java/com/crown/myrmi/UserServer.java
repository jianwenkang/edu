package com.crown.myrmi;

/**
 * @ClassName UserServer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 17:44
 * @Version 1.0
 */
public class UserServer extends User{

    public static void main(String[] args) {
        UserServer userServer = new UserServer();
        userServer.setAge(18);

        UserSkeleton userSkeleton = new UserSkeleton(userServer);
        userSkeleton.start();
    }

}

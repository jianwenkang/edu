package com.crown.chain.demo2;

import com.crown.chain.demo2.entity.DeviceType;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/15
 * @Time 18:26
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        MainHandler mainHandler = new MainHandler();
        TypeHandler typeHandler = new TypeHandler();
        typeHandler.deviceType = new DeviceType(1,"1");
        mainHandler.setNextHandler(typeHandler);
        System.out.println(mainHandler);

        MainHandler mainHandler1 = new MainHandler();
        TypeHandler typeHandler1 = new TypeHandler();
        typeHandler1.deviceType = new DeviceType(2,"2");
        mainHandler1.setNextHandler(typeHandler1);
        System.out.println(mainHandler1);
    }
}

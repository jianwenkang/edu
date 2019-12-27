package com.crown.chain.demo1;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:21
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args) {
        Handler mainHandler = new MainHandler();
        Handler typeHandler = new TypeHandler();
        mainHandler.setNextHandler(typeHandler);
        Handler groupHandler = new GroupHandler();
        typeHandler.setNextHandler(groupHandler);
        System.out.println("========");
        mainHandler.handleRequest();
    }
}

package com.crown.chain.demo1;

/**
 * @ClassName MainHandle
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:25
 * @Version 1.0
 */
public class MainHandler extends Handler{


    @Override
    public void handleRequest() {
        System.out.println("Main method");
        if(nextHandler != null){
            nextHandler.handleRequest();
        }
    }
}

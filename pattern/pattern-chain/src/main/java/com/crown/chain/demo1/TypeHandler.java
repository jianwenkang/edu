package com.crown.chain.demo1;

/**
 * @ClassName TypeHandle
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:27
 * @Version 1.0
 */
public class TypeHandler extends Handler{


    @Override
    public void handleRequest() {
        System.out.println("Type Handler");
        if(nextHandler != null){
            nextHandler.handleRequest();
        }
    }
}

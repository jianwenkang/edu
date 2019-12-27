package com.crown.chain.demo1;

/**
 * @ClassName GroupHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:29
 * @Version 1.0
 */
public class GroupHandler extends Handler{

    @Override
    public void handleRequest() {
        System.out.println("Group Handler");
        if(nextHandler != null){
            nextHandler.handleRequest();
        }
    }
}

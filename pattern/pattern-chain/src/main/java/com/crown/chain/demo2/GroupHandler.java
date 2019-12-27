package com.crown.chain.demo2;

import com.crown.chain.demo2.entity.Group;

/**
 * @ClassName GroupHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:29
 * @Version 1.0
 */
public class GroupHandler extends Handler {

    public Group group;

    @Override
    public void handleRequest() {
        System.out.println("Group Handler");
        if(nextHandler != null){
            nextHandler.handleRequest();
        }
    }
}

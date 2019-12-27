package com.crown.chain.demo;

/**
 * @ClassName GroupHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 18:16
 * @Version 1.0
 */
public class GroupHandler extends Handler{
    @Override
    public boolean handleRequest() {
        System.out.println("GroupHandler");
        boolean result = getGroupSts();
        if(result){
            if(nextHandler != null){
                result = nextHandler.handleRequest();
            }
        }
        return result;
    }

    private boolean getGroupSts(){
        return true;
    }
}

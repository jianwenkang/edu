package com.crown.chain.demo;

/**
 * @ClassName MainHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 18:08
 * @Version 1.0
 */
public class MainHandler extends Handler{
    @Override
    public boolean handleRequest() {
        System.out.println("MainHandler");
        boolean result = getMainSts();
        if(result){
            if(nextHandler != null){
                result = nextHandler.handleRequest();
            }
        }
        return result;
    }

    private boolean getMainSts(){
        return true;
    }
}

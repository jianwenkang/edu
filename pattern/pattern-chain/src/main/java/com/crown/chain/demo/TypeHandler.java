package com.crown.chain.demo;

/**
 * @ClassName TypeHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 18:13
 * @Version 1.0
 */
public class TypeHandler extends Handler{
    @Override
    public boolean handleRequest() {
        System.out.println("TypeHandler");
        boolean result = getTypeSts();
        if(result){
            if(nextHandler != null){
                result = nextHandler.handleRequest();
            }
        }
        return result;
    }

    private boolean getTypeSts(){
        return true;
    }
}

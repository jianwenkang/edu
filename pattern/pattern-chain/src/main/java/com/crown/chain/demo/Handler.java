package com.crown.chain.demo;

/**
 * @ClassName Handler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 18:06
 * @Version 1.0
 */
public abstract class Handler {

    protected Handler nextHandler;

    public abstract boolean handleRequest();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

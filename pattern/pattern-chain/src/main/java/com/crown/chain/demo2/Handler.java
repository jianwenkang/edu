package com.crown.chain.demo2;

import java.util.Objects;

/**
 * @ClassName Handler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:22
 * @Version 1.0
 */
public abstract class Handler {
    protected Handler nextHandler;

    public abstract void handleRequest();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Handler handler = (Handler) o;
        return Objects.equals(nextHandler, handler.nextHandler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextHandler);
    }
}

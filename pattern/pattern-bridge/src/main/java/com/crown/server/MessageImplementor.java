package com.crown.server;

/**
 * @ClassName MessageImplementor
 * @Description TODO  实现发送消息的统一接口
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 15:39
 * @Version 1.0
 */
public interface MessageImplementor {
    /**
     * 发送消息
     * @param message 要发送消息的内容
     * @param toUser  消息的接受者
     */
    public void send(String message , String toUser);
}

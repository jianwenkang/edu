package com.crown.server;

/**
 * @ClassName AbstractMessage
 * @Description TODO  抽象消息类
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 15:38
 * @Version 1.0
 */
public abstract class AbstractMessage {
    //持有一个实现部分的对象
    MessageImplementor impl;
    /**
     * 构造方法，传入实现部分的对象
     * @param impl  实现部分的对象
     */
    public AbstractMessage(MessageImplementor impl){
        this.impl = impl;
    }
    /**
     * 发送消息，委派给实现部分的方法
     * @param message    要发送消息的内容
     * @param toUser    消息的接受者
     */
    public void sendMessage(String message , String toUser){
        this.impl.send(message, toUser);
    }
}

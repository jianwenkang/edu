package com.crown.server;

/**
 * @ClassName MessageSMS
 * @Description TODO  系统内短消息的实现类
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 15:39
 * @Version 1.0
 */
public class MessageSMS implements MessageImplementor {

    @Override
    public void send(String message, String toUser) {

        System.out.println("使用系统内短消息的方法，发送消息'"+message+"'给"+toUser);
    }

}

package com.crown.server;

/**
 * @ClassName CommonMessage
 * @Description TODO  普通消息类
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 15:38
 * @Version 1.0
 */
public class CommonMessage extends AbstractMessage {

    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }
    @Override
    public void sendMessage(String message, String toUser) {
        // 对于普通消息，直接调用父类方法，发送消息即可
        super.sendMessage(message, toUser);
    }
}

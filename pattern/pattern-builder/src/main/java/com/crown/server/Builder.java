package com.crown.server;

import java.util.Date;

/**
 * @ClassName Builder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-22
 * @Time 11:56
 * @Version 1.0
 */
public abstract class Builder {
    protected AutoMessage msg;
    //标题零件的建造方法
    public abstract void buildSubject();
    //内容零件的建造方法
    public abstract void buildBody();
    //收件人零件的建造方法
    public void buildTo(String to){
        msg.setTo(to);
    }
    //发件人零件的建造方法
    public void buildFrom(String from){
        msg.setFrom(from);
    }
    //发送时间零件的建造方法
    public void buildSendDate(){
        msg.setSendDate(new Date());
    }
    /**
     * 邮件产品完成后，用此方法发送邮件
     * 此方法相当于产品返还方法
     */
    public void sendMessage(){
        msg.send();
    }
}

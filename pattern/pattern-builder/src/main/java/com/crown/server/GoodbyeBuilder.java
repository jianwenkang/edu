package com.crown.server;

/**
 * @ClassName GoodbyeBuilder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-22
 * @Time 11:57
 * @Version 1.0
 */
public class GoodbyeBuilder extends Builder {

    public GoodbyeBuilder(){
        msg = new GoodbyeMessage();
    }
    @Override
    public void buildBody() {
        // TODO Auto-generated method stub
        msg.setBody("欢送内容");
    }

    @Override
    public void buildSubject() {
        // TODO Auto-generated method stub
        msg.setSubject("欢送标题");
    }

}

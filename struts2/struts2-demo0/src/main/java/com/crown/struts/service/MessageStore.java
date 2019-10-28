package com.crown.struts.service;

/**
 * @ClassName MessageStore
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/1
 * @Time 9:54
 * @Version 1.0
 */
public class MessageStore {
    private String message;

    public MessageStore() {
        message = "Hello Struts User";
    }

    public String getMessage() {
        return message;
    }
}

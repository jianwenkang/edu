package com.crown.struts.action;

import com.crown.struts.service.MessageStore;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HelloWorldAction
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/1
 * @Time 9:54
 * @Version 1.0
 */
public class HelloWorldAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldAction.class);
    private MessageStore messageStore;
    @Override
    public String execute() {
        messageStore = new MessageStore() ;
        logger.debug("===========");

        return SUCCESS;
    }


    public String login() {
        messageStore = new MessageStore() ;
        logger.debug("=====login======");

        return SUCCESS;
    }

    public String logout() {
        messageStore = new MessageStore() ;
        logger.debug("=====logout======");
        return SUCCESS;
    }
    public MessageStore getMessageStore() {
        return messageStore;
    }

}

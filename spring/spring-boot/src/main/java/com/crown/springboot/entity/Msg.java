package com.crown.springboot.entity;

/**
 * @ClassName Msg
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:11
 * @Version 1.0
 */
public class Msg {

    private String title;

    private String content;

    private String etraInfo;



    public Msg(String title, String content, String etraInfo) {

        super();

        this.title = title;

        this.content = content;

        this.etraInfo = etraInfo;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public String getContent() {

        return content;

    }

    public void setContent(String content) {

        this.content = content;

    }

    public String getEtraInfo() {

        return etraInfo;

    }

    public void setEtraInfo(String etraInfo) {

        this.etraInfo = etraInfo;

    }



}


package com.crown.mybatis.entity;

import java.util.List;

/**
 * @ClassName Father
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/19
 * @Time 10:08
 * @Version 1.0
 */
public class Father {
    private Integer id;

    private String name;

    private List<Son> sonList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Son> getSonList() {
        return sonList;
    }

    public void setSonList(List<Son> sonList) {
        this.sonList = sonList;
    }

    @Override
    public String toString() {
        return "Father{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sonList=" + sonList +
                '}';
    }
}

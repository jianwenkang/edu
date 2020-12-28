package com.crown.entity;

import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-10-12
 * @Time 9:49
 * @Version 1.0
 */
@Table(name="user")
public class User  {
    private Integer id ;
    private Integer age ;
    private String name ;
    private Date createDate ;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

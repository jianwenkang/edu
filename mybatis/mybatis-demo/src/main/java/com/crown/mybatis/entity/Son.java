package com.crown.mybatis.entity;

/**
 * @ClassName Son
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/19
 * @Time 10:10
 * @Version 1.0
 */
public class Son {

    private Integer id;

    private String name;

    private Father father;

    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", father=" + father +
                '}';
    }

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

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }
}

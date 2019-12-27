package com.crown.mybatis.demo1.entity;

/**
 * @ClassName Phnoe
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:41
 * @Version 1.0
 */
public class Phnoe {

    private Integer phoneId;

    private String phoneNumber;

    @Override
    public String toString() {
        return "Phnoe{" +
                "phoneId=" + phoneId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

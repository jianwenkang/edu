package com.crown.entity;

/**
 * @ClassName Account
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/5
 * @Time 14:07
 * @Version 1.0
 */
public class Account {
    private Integer id;

    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double blance) {
        this.balance = blance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}

package com.crown.dao;

import com.crown.entity.Account;

/**
 * @ClassName AccountDao
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/5
 * @Time 13:56
 * @Version 1.0
 */
public interface AccountDao {

    Account queryOne(Integer id);

    int queryCount();

    int insertOne(Double blance);

    int insertAccount(Account account);

    int updateOne(Account account);
}

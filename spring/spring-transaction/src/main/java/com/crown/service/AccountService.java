package com.crown.service;

import com.crown.dao.AccountDao;
import com.crown.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/5
 * @Time 14:11
 * @Version 1.0
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(readOnly = true)
    public Account queryOne(Integer id) {
        Account account = accountDao.queryOne(id);
        return account;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation  = Isolation.READ_UNCOMMITTED)
    public int addAccount(Account account){
        int i = accountDao.insertAccount(account);
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("提交事务");
        return i;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation  = Isolation.REPEATABLE_READ)
    public int queryCount(){
        int i = accountDao.queryCount();
        System.out.println(i);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = accountDao.queryCount();
        System.out.println(i);
        return i;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOne(Account account){
        int i = accountDao.updateOne(account);
        System.out.println("提交事务");
        return i;
    }
}

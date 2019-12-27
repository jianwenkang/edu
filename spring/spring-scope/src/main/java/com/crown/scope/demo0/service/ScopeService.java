package com.crown.scope.demo0.service;

import com.crown.scope.demo0.dao.ScopeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScopeService
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/11
 * @Time 15:25
 * @Version 1.0
 */
@Service
public class ScopeService {

    @Autowired
    private ScopeDao scopeDao;

    public void say(){
        System.out.println(Thread.currentThread().getName()+":"+System.identityHashCode(scopeDao)+"ScopeService");
        scopeDao.say();
    }
}

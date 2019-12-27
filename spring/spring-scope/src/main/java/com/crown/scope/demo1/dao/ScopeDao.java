package com.crown.scope.demo1.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScopeDao
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/11
 * @Time 15:25
 * @Version 1.0
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeDao {

    public void say(ApplicationContext context){
        System.out.println(Thread.currentThread().getName()+":ScopeDao");
    }
}

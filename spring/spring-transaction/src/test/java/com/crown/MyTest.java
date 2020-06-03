package com.crown;

import com.crown.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @ClassName MyTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020/4/13
 * @Time 17:30
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-dao.xml"})
public class MyTest {

    @Autowired
    private DataSource dataSource1;

    @Autowired
    private AccountService accountService;

    @Test
    public void test(){

    }
}

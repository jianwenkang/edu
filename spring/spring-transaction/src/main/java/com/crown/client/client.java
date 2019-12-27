package com.crown.client;

import com.crown.entity.Account;
import com.crown.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/6/5
 * @Time 14:23
 * @Version 1.0
 */
public class client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/conf/spring-dao.xml");
        AccountService as = context.getBean(AccountService.class);

        new Thread(()->{
            int i = as.queryCount();
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Account account = new Account();
            account.setId(1);
            account.setBalance(200.0);
            int i = as.updateOne(account);
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Account account = new Account();
            account.setBalance(100.0);
            as.addAccount(account);
        });

        new Thread(() -> {
            Account account = new Account();
            account.setId(1);
            account.setBalance(100.0);
            as.updateOne(account);
        });

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Account account = as.queryOne(1);
            System.out.println(account);
        });

    }
}
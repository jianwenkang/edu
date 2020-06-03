package com.crown.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @ClassName TransactionConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:06
 * @Version 1.0
 */
//@Configuration

//@ComponentScan

public class TransactionConfig implements TransactionManagementConfigurer {

    @Autowired

    private DataSource dataSource;



    @Bean(name = "transactionManager")

    @Override

    public PlatformTransactionManager annotationDrivenTransactionManager() {

        return new DataSourceTransactionManager(dataSource);

    }



}

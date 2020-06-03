package com.crown.springboot.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @ClassName MyBatisConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:05
 * @Version 1.0
 */
//@Configuration

//@ComponentScan

public class MyBatisConfig {



    @Autowired

    private DataSource dataSource;



    @Bean(name = "sqlSessionFactory")

    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);

        // sessionFactory.setPlugins(new Interceptor[]{new PageInterceptor()});

        sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));

        return sessionFactory;

    }



}

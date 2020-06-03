package com.crown.springboot.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName MyBatisScannerConfig
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:06
 * @Version 1.0
 */

//@Configuration

public class MyBatisScannerConfig {

    @Bean

    public MapperScannerConfigurer MapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setBasePackage("com.us.example.dao");

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;

    }

}

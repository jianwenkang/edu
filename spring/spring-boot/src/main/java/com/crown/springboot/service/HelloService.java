package com.crown.springboot.service;

import com.crown.springboot.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/13
 * @Time 17:59
 * @Version 1.0
 */
@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public void sayHello(){
        int i = helloDao.selectHello();
        System.out.println(i);
    }
}

package com.crown.springboot.dao;

import com.crown.springboot.entity.SysUser;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 11:10
 * @Version 1.0
 */
public interface UserDao {

    public SysUser findByUserName(String username);

}

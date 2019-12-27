package com.crown.mybatis.demo1.mapper;

import com.crown.mybatis.demo1.entity.User;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:32
 * @Version 1.0
 */
public interface UserMapper {
    User selectOne(Integer id);
    User selectMap(Integer id);
}

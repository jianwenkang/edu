package com.crown.mybatis.demo2.mapper;

import com.crown.mybatis.demo2.entity.User;
import com.crown.mybatis.entity.Father;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 10:48
 * @Version 1.0
 */
public interface UserMapper {
    int insertOne(User user);

    int insertMore(List<User> users);

    int deleteOne(Integer primaryKey);

    int deleteMore(List<User> users);

    int updateOne(User user);

    int updateMore(List<User> users);

    User selectOne(Integer primaryKey);

    List<User> selectMore(List<User> users);

    List<Father> selectFather();
}

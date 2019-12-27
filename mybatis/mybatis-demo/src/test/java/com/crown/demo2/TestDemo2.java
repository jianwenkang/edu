package com.crown.demo2;


import com.crown.mybatis.demo2.entity.User;
import com.crown.mybatis.demo2.mapper.UserMapper;
import com.crown.mybatis.entity.Father;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:54
 * @Version 1.0
 */
public class TestDemo2 {

    @Test
    public void test1() throws IOException {
        String resource = "demo2/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(57,null,null);
        User user1 = new User(56,null,"dd");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        List<User> users1 = mapper.selectMore(users);
        System.out.println(users1);
    }

    @Test
    public void test2() throws IOException {
        String resource = "demo2/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Father> fathers =
                mapper.selectFather();
        for (Father father:fathers
             ) {
            System.out.println(father);
        }
    }
}

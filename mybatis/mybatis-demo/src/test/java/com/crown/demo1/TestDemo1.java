package com.crown.demo1;

import com.crown.mybatis.demo1.entity.User;
import com.crown.mybatis.demo1.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:54
 * @Version 1.0
 */
public class TestDemo1 {

    @Test
    public void test1() throws IOException {
        String resource = "demo1/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        sqlSession.selectList("", UserMapper.class);
        User user = mapper.selectMap(1);
        System.out.println(user.getUserId());
        //System.out.println(user.getAddress());
    }
}

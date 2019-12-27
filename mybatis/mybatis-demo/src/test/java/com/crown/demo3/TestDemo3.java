package com.crown.demo3;


import com.crown.mybatis.demo3.TestJoin;
import com.crown.mybatis.entity.P;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:54
 * @Version 1.0
 */
public class TestDemo3 {

    @Test
    public void test1() throws IOException {
        String resource = "demo3/conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
        TestJoin mapper = sqlSession.getMapper(TestJoin.class);
        List<P> ps = mapper.selectP();
        for (P p: ps
             ) {
            System.out.println(p);
        }
    }

}

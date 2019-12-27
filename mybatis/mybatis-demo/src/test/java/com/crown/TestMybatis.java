package com.crown;

import com.crown.mybatis.entity.NewTest;
import com.crown.mybatis.mapper.TestDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Crown on 2019/2/20.
 */
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        TestDao mapper = sqlSession.getMapper(TestDao.class);
        List<Map<String, Object>> maps = mapper.selectAll();
        System.out.println(maps);
    }

    @Test
    public void test01() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        TestDao mapper = sqlSession.getMapper(TestDao.class);

        Map<String, String> integerStringTreeMap = new TreeMap<>();
        integerStringTreeMap.put("1","1");
        integerStringTreeMap.put("2","2");
        integerStringTreeMap.put("3","3");
        mapper.insertMap(integerStringTreeMap);
        sqlSession.commit();
    }
    @Test
    public void test02() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        TestDao mapper = sqlSession.getMapper(TestDao.class);

        Map<Integer, Double> integerStringTreeMap = new TreeMap<>();
        integerStringTreeMap.put(1,1.1);
        integerStringTreeMap.put(2,2.2);
        integerStringTreeMap.put(3,3.3);
        int i = mapper.insertRunData(1, integerStringTreeMap, new Date(), 12, 30);
        sqlSession.commit();
    }
    @Test
    public void test03(){
        Map<Integer, Double> integerStringTreeMap = new TreeMap<>();
        integerStringTreeMap.put(1,1.1);
        integerStringTreeMap.put(2,2.2);
        integerStringTreeMap.put(3,3.3);
        Set<Map.Entry<Integer, Double>> entries = integerStringTreeMap.entrySet();
        for (Map.Entry<Integer, Double> map:integerStringTreeMap.entrySet()
             ) {
            System.out.println();
        }
    }
    @Test
    public void test04() throws IOException {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        TestDao mapper = sqlSession.getMapper(TestDao.class);

        List<NewTest> tests = mapper.selectTest();

        System.out.println(tests);
    }
    @Test
    public void test05() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:my1sql://127.0.0.1:3306/em_new1","root", "root");

    }

    @Test
    public void test06() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.crown.Demo");

    }
}
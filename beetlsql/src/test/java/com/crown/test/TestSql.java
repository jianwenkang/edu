package com.crown.test;

import com.crown.entity.User;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @ClassName TestSql
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-10-12
 * @Time 9:44
 * @Version 1.0
 */
public class TestSql {
    @Test
    public void test(){
        ConnectionSource source = ConnectionSourceHelper.getSimple("com.mysql.cj.jdbc.Driver", "jdbc:mysql://192.168.222.21:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8", "root", "root");
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        //Query<User> query = sqlManager.query(User.class);
        User user = new User();
        user.setCreateDate(new Date());
        System.out.println(user);
        sqlManager.insert(user);

    }

    @Test
    public void test1() throws Exception {
        //Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.222.21:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8", "root", "root");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.222.21:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `test`.`user`(`name`, `department_id`, `create_time`) VALUES ('1', 1, '2020-10-12 10:03:50')");
        //PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `test`.`user`(`name`, `department_id`, `create_time`) VALUES ('1', 1, '2018-09-12T19:19:30.000+0000')");
        preparedStatement.execute();
        PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM `user` WHERE id = 8");
        ResultSet resultSet = preparedStatement1.executeQuery();
        boolean next = resultSet.next();
        int anInt = resultSet.getInt(1);
        String name = resultSet.getString("name");
        System.out.println(resultSet.getTime("create_time"));

    }

    @Test
    public void testThread(){

    }
}

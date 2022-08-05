package com.bzy.jdbc;

import com.bzy.pojo.Note;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyiBi
 * @date 2022/7/24
 * JDBC ResultSet
 */
public class JDBCUserLoginDemo {


    @Test
    public void testUserLogin() throws Exception {

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //存储用户名和密码
        String name = "bzy";
        String pwd = "e10adc3949ba59abbe56e057f20f883e";

        //3.定义SQL
        String sql = "select * from tb_user where uname = '" + name + "' and upwd = '" + pwd + "'";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        //判断是否登录成功
        if (resultSet.next()) {
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }

        //7.释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }

    /**
     * 测试SQL注入
     * @throws Exception
     */
    @Test
    public void testUserLogin_Inject() throws Exception {

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //存储用户名和密码
        String name = "asdjhjlk";
        String pwd = "' or '1' = '1";

        //3.定义SQL
        String sql = "select * from tb_user where uname = '" + name + "' and upwd = '" + pwd + "'";
        System.out.println(sql);

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        //判断是否登录成功
        if (resultSet.next()) {
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }

        //7.释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }


}

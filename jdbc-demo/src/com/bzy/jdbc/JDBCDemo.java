package com.bzy.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author zhenyiBi
 * @date 2022/7/24
 * JDBC快速入门、DriverManager
 */
public class JDBCDemo {

    public static void main(String[] args) throws Exception {
        //1.注册驱动，mysql5之后的驱动包可忽略这一步
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL
        String sql = "update tb_note set content='修改的内容1' where noteId=1";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        int count = statement.executeUpdate(sql);//受影响的行数

        //6.处理结果
        System.out.println("受影响的行数：" + count);

        //7.释放资源
        statement.close();
        conn.close();

    }
}

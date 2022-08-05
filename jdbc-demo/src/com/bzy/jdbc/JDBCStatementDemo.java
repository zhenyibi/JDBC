package com.bzy.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhenyiBi
 * @date 2022/7/24
 * JDBC Statement
 */
public class JDBCStatementDemo {

    /**
     * 执行DML语句 数据的增删改
     * @throws Exception
     */
    @Test
    public void testDML() throws Exception {
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
        if (count > 0) {
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }

        //7.释放资源
        statement.close();
        conn.close();

    }

    /**
     * 执行DDL语句 数据库表的增删改
     * @throws Exception
     */
    @Test
    public void testDDL() throws Exception {
        //1.注册驱动，mysql5之后的驱动包可忽略这一步
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL
        String sql = "drop DataBase db1";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        int count = statement.executeUpdate(sql);//受影响的行数,DDL语句执行成功也可能返回0

        //6.处理结果
//        if (count > 0) {
//            System.out.println("修改成功！");
//        }else{
//            System.out.println("修改失败！");
//        }
        System.out.println(count);

        //7.释放资源
        statement.close();
        conn.close();

    }
}

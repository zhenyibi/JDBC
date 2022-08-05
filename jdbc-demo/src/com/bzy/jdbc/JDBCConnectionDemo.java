package com.bzy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhenyiBi
 * @date 2022/7/24
 * JDBC Connection
 */
public class JDBCConnectionDemo {

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
        String sql1 = "update tb_note set content='修改的内容1' where noteId=1";
        String sql2 = "update tb_note set content='修改的内容2' where noteId=2";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        try {
            //开始事务
            conn.setAutoCommit(false);

            //5.执行SQL
            int count1 = statement.executeUpdate(sql1);//受影响的行数
            //6.处理结果
            System.out.println("受影响的行数：" + count1);

//            int i = 3/0;

            //5.执行SQL
            int count2 = statement.executeUpdate(sql2);//受影响的行数
            //6.处理结果
            System.out.println("受影响的行数：" + count2);

            //提交事务
            conn.commit();

        } catch (Exception throwables) {
            throwables.printStackTrace();
            conn.rollback();
        }

        //7.释放资源
        statement.close();
        conn.close();

    }
}

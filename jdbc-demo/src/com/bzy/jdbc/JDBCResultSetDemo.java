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
public class JDBCResultSetDemo {

    /**
     * 执行DQL语句 数据的查询
     *
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception {
        //1.注册驱动，mysql5之后的驱动包可忽略这一步
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL
        String sql = "select * from tb_note";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        //6.处理结果，遍历结果集中的所有数据
        //6.1 光标向下一行，并判断当前行是否有数据
//        while (resultSet.next()) {
//            //6.2 获取数据
//            int id = resultSet.getInt(1);
//            String title = resultSet.getString(2);
//            String content = resultSet.getString(3);
//            System.out.println("id:" + id);
//            System.out.println("title:" + title);
//            System.out.println("content:" + content);
//            System.out.println("---------------");
//        }

        //6.1 光标向下一行，并判断当前行是否有数据
        while (resultSet.next()) {
            //6.2 获取数据
            int id = resultSet.getInt("noteId");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            System.out.println("id:" + id);
            System.out.println("title:" + title);
            System.out.println("content:" + content);
            System.out.println("---------------");
        }


        //7.释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }

    /**
     * 执行DQL语句 数据的查询
     * 查询表数据，封装为Note对象中，并且存储到ArrayList集合中
     * 1，定义实体类Note
     * 2，查询数据，封装到对象中
     * 3，将对象存入ArrayList集合中
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception {
        //1.注册驱动，mysql5之后的驱动包可忽略这一步
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        //String url = "jdbc:mysql://localhost:3306/db_mynote";
        String url = "jdbc:mysql:///db_mynote?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义SQL
        String sql = "select * from tb_note";

        //4.获取执行SQL的对象 statement
        Statement statement = conn.createStatement();

        //5.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        //创建集合
        List<Note> list = new ArrayList<>();

        //6.1 光标向下一行，并判断当前行是否有数据
        while (resultSet.next()) {
            Note note = new Note();

            //6.2 获取数据
            int id = resultSet.getInt("noteId");
            String title = resultSet.getString("title");
            String content = resultSet.getString("content");
            note.setNoteId(id);
            note.setTitle(title);
            note.setContent(content);

            //存入集合
            list.add(note);

        }

        System.out.println(list);


        //7.释放资源
        resultSet.close();
        statement.close();
        conn.close();

    }


}

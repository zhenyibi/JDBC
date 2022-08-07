package com.bzy.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhenyiBi
 * @date 2022/8/7
 * Druid数据库连接池Demo
 */
public class DruidDemo {

    public static void main(String[] args) throws Exception {

        //获取当前文件相对路径
        //System.out.println(System.getProperty("user.dir"));
        //D:\GitProject\JDBC

        //1,导入JAR包

        //2,定义配置文件

        //3,加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4,获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5,获取数据库连接 Connection
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}

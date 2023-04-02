package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {


    @Test
    //测试Spring创建Druid连接池
    public void TestSpring_Druid() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("DruidDataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    //测试手动创建c3p0（加载properties配置文件）
    public void Testc3p0() throws Exception {
        //读取配置文件，ResourceBundle的getBundle方法，从resources路径下去找.properties文件
        ResourceBundle resourceBundle=ResourceBundle.getBundle("jdbc");
        String driver=resourceBundle.getString("jdbc.driver");
        String url=resourceBundle.getString("jdbc.url");
        String username=resourceBundle.getString("jdbc.username");
        String password=resourceBundle.getString("jdbc.password");
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //设置连接参数
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接对象
        connection.close();
    }
    @Test
    //测试手动创建Druid
    public void TestDruid() throws Exception {
        //创建数据源对象
        DruidDataSource dataSource=new DruidDataSource();
        //设置基本的连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///mybatis?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        //获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭连接对象
        connection.close();
    }
}

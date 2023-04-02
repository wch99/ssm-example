package com.itheima.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.itheima.Service.UserService;
import com.itheima.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;


public class UserController {

    public static void main(String[] args) throws SQLException {
        //加载核心配置类
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        DruidDataSource dataSource= (DruidDataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        userService.save();
    }
}

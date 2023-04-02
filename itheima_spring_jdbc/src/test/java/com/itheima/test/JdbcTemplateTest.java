package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    //测试jdbcTemplate开发步骤
    public void test1(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源连接数据库
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///mybatis?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        jdbcTemplate.update("insert into account values('wch',8888888)");
        jdbcTemplate.update("insert into account values(?,?)","tom",5000);
    }
    @Test
    //spring产生JdbcTemplate对象
    public void test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }
}

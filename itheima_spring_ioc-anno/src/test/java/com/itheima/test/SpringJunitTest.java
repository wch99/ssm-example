package com.itheima.test;

import com.itheima.Service.UserService;
import com.itheima.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Resource(name="dataSource")
    private DataSource dataSource;
    @Test
    public void test1() {
        userService.save();
    }
    @Test
    public void test2() {
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

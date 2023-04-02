package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",999999,"wch");
        jdbcTemplate.update("insert into account values(?,?)","aab",1234);
        jdbcTemplate.update("insert into account values(?,?)","abc",12324);
    }
    @Test
    public void testQueryAll(){
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }
    @Test
    public void testQueryForList(){
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "wch");
        System.out.println(accounts);
    }
    @Test
    public void testQueryForCount(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }
}

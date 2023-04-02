package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njit.domain.Account;
import com.njit.domain.User;
import com.njit.mapper.AccountMapper;
import com.njit.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数 当前页+每页显示的条数
        PageHelper.startPage(1,3);

        List<User> userList= userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获取与分页有关的参数
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("每页显示条数:"+pageInfo.getPageSize());
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("上一页:"+pageInfo.getPrePage());
        System.out.println("下一页:"+pageInfo.getNextPage());
        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());
        //关闭资源
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建user
        User user=new User();
        user.setUserName("wch1321");
        user.setPassword("123456");
        user.setNickName("wwccchhh");
        user.setBirthday(new Date());
        userMapper.save(user);
        //提交
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
    @Test
    public void testAccountSaveOne() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        //创建user
        Account account=new Account();
        account.setName("wch");
        account.setMoney(99999);
        accountMapper.saveOne(account);
        //提交
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}

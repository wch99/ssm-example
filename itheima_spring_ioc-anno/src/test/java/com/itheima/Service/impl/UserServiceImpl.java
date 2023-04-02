package com.itheima.Service.impl;

import com.itheima.Dao.UserDao;
import com.itheima.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


//<bean id="userService" class="com.itheima.Service.impl.UserServiceImpl"></bean>
@Service("userService")
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    @Value("${jdbc.driver}")//注入一般属性，可以从容器中找对应properties的key，然后赋值给它
    private String driver;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @Override
    public void save() {
        System.out.println("driver:"+driver);
        userDao.save();
    }
}

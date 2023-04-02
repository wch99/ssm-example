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
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @Override
    public void save() {
        userDao.save();
    }
}

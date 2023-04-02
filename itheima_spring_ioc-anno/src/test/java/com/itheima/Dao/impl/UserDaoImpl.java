package com.itheima.Dao.impl;
import com.itheima.Dao.UserDao;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.itheima.Dao.impl.UserDaoImpl"></bean>
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running......");
    }
}

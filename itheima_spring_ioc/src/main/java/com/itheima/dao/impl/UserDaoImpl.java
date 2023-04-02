package com.itheima.dao.impl;
import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import java.util.List;
import java.util.Map;
import java.util.Properties;
public class UserDaoImpl implements UserDao {
    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    @Override
    public void save() {
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running...");
    }
}

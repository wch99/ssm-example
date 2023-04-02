package com.njit.service.impl;

import com.njit.domain.User;
import com.njit.mapper.UserMapper;
import com.njit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByName(String username,String password) {
        User user = userMapper.selectByName(username, password);
        return user;
    }
}

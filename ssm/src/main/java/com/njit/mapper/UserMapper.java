package com.njit.mapper;

import com.njit.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserMapper {
     List<User> findAll();
     void save(User user);
     User selectByName(@Param("username") String username,@Param("password") String password);
}

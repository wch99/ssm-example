package com.njit.mapper;

import com.njit.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AccountMapper {
    List<Account> selectAll();
    void saveOne(Account account);
    void deleteOne(@Param("id")int id);
}

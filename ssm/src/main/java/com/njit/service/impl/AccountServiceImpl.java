package com.njit.service.impl;

import com.njit.domain.Account;
import com.njit.mapper.AccountMapper;
import com.njit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = accountMapper.selectAll();
        return accounts;
    }

    @Override
    public void saveOne(Account account) {
        accountMapper.saveOne(account);
    }

    @Override
    public void deleteOne(int id) {
        accountMapper.deleteOne(id);
    }
}

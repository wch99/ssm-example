package com.njit.service;

import com.njit.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> selectAll();
    void saveOne(Account account);
    void deleteOne(int id);
}

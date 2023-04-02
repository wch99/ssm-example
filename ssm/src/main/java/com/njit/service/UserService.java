package com.njit.service;

import com.njit.domain.User;

public interface UserService {
    User selectByName(String username, String password);
}

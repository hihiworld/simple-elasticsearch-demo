package com.yaologos.searchhouse.service;

import com.yaologos.searchhouse.entity.User;

public interface UserService {
    User findUserByName(String username);
}
package com.yaologos.searchhouse.service.Impl;

import com.yaologos.searchhouse.entity.User;
import com.yaologos.searchhouse.repositories.UserRepository;
import com.yaologos.searchhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByName(String username) {
        return userRepository.findUserByName(username);
    }
}
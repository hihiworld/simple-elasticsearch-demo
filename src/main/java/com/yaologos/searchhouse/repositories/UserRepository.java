package com.yaologos.searchhouse.repositories;

import com.yaologos.searchhouse.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByName(String name);
}
package com.alikagan.se3355final.services;

import com.alikagan.se3355final.entities.User;

import java.util.List;

public interface UserService2 {
    List<User> findAll();
    User findById(Long id);
    public User save(User user);
}

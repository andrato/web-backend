package com.shop.project.service;

import com.shop.project.domain.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);

    public User findByEmail(String email);

}

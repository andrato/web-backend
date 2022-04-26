package com.shop.project.service;

import com.shop.project.domain.Role;

import java.util.List;

public interface RoleService
{
    Role findByName(String roleName);
    List<Role> findAll();
    Role findById(Long id);
}

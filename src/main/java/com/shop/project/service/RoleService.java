package com.shop.project.service;

import com.shop.project.domain.ERole;
import com.shop.project.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService
{
    Optional<Role> findByName(ERole roleName);
    List<Role> findAll();
    Role findById(Long id);
}

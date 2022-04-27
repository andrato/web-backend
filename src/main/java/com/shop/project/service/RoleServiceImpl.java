package com.shop.project.service;

import com.shop.project.domain.ERole;
import com.shop.project.domain.Role;
import com.shop.project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService
{
    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) { this.roleRepository = roleRepository; }

    @Override
    public List<Role> findAll()
    {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id)
    {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (!roleOptional.isPresent())
        {
            throw new RuntimeException("Role not found!");
            //throw new userOptional("participant " + l + " not found");
        }
        return roleOptional.get();
    }

    @Override
    public Optional<Role> findByName(ERole roleName)
    {
        return roleRepository.findByName(roleName);
    }
}

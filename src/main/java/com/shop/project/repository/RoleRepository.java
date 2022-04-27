package com.shop.project.repository;

import com.shop.project.domain.ERole;
import com.shop.project.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    @Query("select r from Role r where r.name = :roleName")
    Optional<Role> findByName(@Param("roleName") ERole roleName);
}

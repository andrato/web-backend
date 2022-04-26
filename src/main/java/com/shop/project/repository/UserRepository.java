package com.shop.project.repository;

import com.shop.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Query("select u from User u where u.email = :userEmail")
    Optional<User> findByEmail(@Param("userEmail") String userEmail);

    @Query("select u from User u where u.email = :userEmail")
    User findByUsername(@Param("userEmail") String userEmail);
}

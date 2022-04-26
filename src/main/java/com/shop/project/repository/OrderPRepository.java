package com.shop.project.repository;

import com.shop.project.domain.OrderP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPRepository extends JpaRepository<OrderP, Long>
{
    @Query("select o from OrderP o where o.user.id = :id")
    List<OrderP> findByUser(@Param("id") Long id);
}

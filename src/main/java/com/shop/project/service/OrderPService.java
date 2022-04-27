package com.shop.project.service;

import com.shop.project.domain.Category;
import com.shop.project.domain.OrderP;

import java.util.List;
import java.util.Optional;

public interface OrderPService
{
    List<OrderP> findByUser(Long id);
    List<OrderP> findAll();
    OrderP save(OrderP order);
    OrderP update(OrderP order);
    void deleteById(Long id);
    Optional<OrderP> getUnfinishOrder();
}

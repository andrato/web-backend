package com.shop.project.service;

import com.shop.project.domain.OrderP;

import java.util.List;

public interface OrderPService
{
    List<OrderP> findByUser(Long id);
}

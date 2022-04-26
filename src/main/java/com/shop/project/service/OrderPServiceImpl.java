package com.shop.project.service;

import com.shop.project.domain.OrderP;
import com.shop.project.repository.OrderPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderPServiceImpl implements OrderPService
{
    OrderPRepository orderRepository;

    @Autowired
    public OrderPServiceImpl(OrderPRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderP> findByUser(Long id)
    {
        List<OrderP> orders = new LinkedList<>();
        orderRepository.findByUser(id).iterator().forEachRemaining(orders::add);
        return orders;
    }
}

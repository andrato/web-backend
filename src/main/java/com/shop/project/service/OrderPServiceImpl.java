package com.shop.project.service;

import com.shop.project.domain.OrderP;
import com.shop.project.exceptions.EntityNotFoundException;
import com.shop.project.repository.OrderPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderPServiceImpl implements OrderPService
{
    OrderPRepository orderRepository;

    @Autowired
    public OrderPServiceImpl(OrderPRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderP> findByUser(Long id) {
        return orderRepository.findByUser(id);
    }

    @Override
    public List<OrderP> findAll() {
        List<OrderP> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public OrderP save(OrderP order) {
        OrderP savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    @Override
    public OrderP update(OrderP order) {
        if (orderRepository.existsById(order.getId())) {
            return orderRepository.save(order);
        } else {
            throw new EntityNotFoundException(String.format("There is no order with id=%s in the database!", order.getId().toString()));
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<OrderP> orderPOptional = orderRepository.findById(id);
        if (!orderPOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        OrderP orderP = orderPOptional.get();

        orderRepository.save(orderP);
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<OrderP> getUnfinishOrder() {
        return orderRepository.getUnfinishOrder();
    }
}

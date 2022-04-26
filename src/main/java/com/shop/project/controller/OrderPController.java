package com.shop.project.controller;

import com.shop.project.domain.*;
import com.shop.project.service.AnimalService;
import com.shop.project.service.OrderPService;
import com.shop.project.service.ProductService;
import com.shop.project.service.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderPController
{
    @Autowired
    UserService userService;

    @Autowired
    OrderPService orderPService;

    AnimalService  animalService;

    @Autowired
    public OrderPController(OrderPService orderPService)
    {
        this.orderPService = orderPService;
    }

    @RequestMapping
    public ResponseEntity<List<OrderP>> findAll()
    {
        List<OrderP> orders = orderPService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderP>> showOrdersFromUser(@RequestParam Long id)
    {
        List<OrderP> orders = orderPService.findByUser(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> newOrder (@RequestBody OrderP order)
    {
        OrderP orderSaved = orderPService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByOrderId(@RequestParam Long id)
    {
        orderPService.deleteById(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

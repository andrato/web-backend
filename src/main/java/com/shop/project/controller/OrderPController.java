package com.shop.project.controller;

import com.shop.project.domain.*;
import com.shop.project.service.AnimalService;
import com.shop.project.service.OrderPService;
import com.shop.project.service.ProductService;
import com.shop.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderPController
{
    @Autowired
    UserService userService;

    @Autowired
    OrderPService orderPService;

    @Autowired
    ProductService productService;


    @Autowired
    public OrderPController(OrderPService orderPService)
    {
        this.orderPService = orderPService;
    }

    @GetMapping
    public ResponseEntity<List<OrderP>> findAll()
    {
        List<OrderP> orders = orderPService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderP>> showOrdersFromUser(@PathVariable Long id)
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

    @PostMapping("/products")
    public ResponseEntity<Void> addToOrder(@RequestBody Long productId)
    {
        User user = userService.findByEmail("andratomi94@gmail.com");
        Product product = productService.findById(productId);

        Optional<OrderP> order = orderPService.getUnfinishOrder();
        if(!order.isPresent()) {
            // create order
            OrderP orderNew = new OrderP();
            orderNew.setUser(user);
            orderNew.addProductToOrder(product, user.getEmail());
            return newOrder(orderNew);
        }

        //altfel, adaug la orderul existent
        OrderP existingOrder = order.get();
        existingOrder.addProductToOrder(product, user.getEmail());
        orderPService.save(existingOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

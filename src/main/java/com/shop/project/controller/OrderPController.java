package com.shop.project.controller;

import com.shop.project.domain.*;
import com.shop.project.service.AnimalService;
import com.shop.project.service.OrderPService;
import com.shop.project.service.ProductService;
import com.shop.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

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

    @GetMapping("/user/{id}")
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

    @PutMapping("{id}")
    public ResponseEntity<Void> finishOrder(@PathVariable Long id)
    {
        orderPService.finishOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/products/{productId}")
    public ResponseEntity<Void> addToOrder(@PathVariable Long productId)
    {
        logger.info("start");
        User user = userService.findByEmail("andratomi94@gmail.com");
        Product product = productService.findById(productId);

        if(user.getEmail() == null || product.getName() == null) {
            logger.info("nu e bine");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

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

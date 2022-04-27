package com.shop.project.controller;

import com.shop.project.domain.User;
import com.shop.project.service.OrderPService;
import com.shop.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    OrderPService orderPService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> usersList() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> showById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> showById(@PathVariable String username) {
        User user = userService.findByEmail(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody User user) {
        try {
            logger.info("in save " + user.toString());
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User user = userService.updateInfo();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}




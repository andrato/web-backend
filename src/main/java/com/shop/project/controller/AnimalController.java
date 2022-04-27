package com.shop.project.controller;

import com.shop.project.domain.Animal;
import com.shop.project.service.AnimalService;
import com.shop.project.service.ProductService;
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
@RequestMapping("/animals")
public class AnimalController
{
    @Autowired
    UserService userService;

    @Autowired
    AnimalService animalService;

    @Autowired
    ProductService productService;

    @Autowired
    public AnimalController(UserService userService, AnimalService animalService, ProductService productService)
    {
        this.userService = userService;
        this.animalService = animalService;
        this.productService = productService;
    }

    Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @GetMapping
    public ResponseEntity<List<Animal>> findAll()
    {
        List<Animal> animals = animalService.findAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }
}

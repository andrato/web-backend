package com.shop.project.controller;

import com.shop.project.service.AnimalService;
import com.shop.project.service.ProductService;
import com.shop.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

//    @GetMapping("/animal/{id}")
//    public String productList(@PathVariable String id, Model model)
//    {
//        //logger.trace("id = " + id + "\n");
//        Animal animal               = animalService.findById(Long.valueOf(id));
//        List<Animal> animals        = animalService.findAll();
//        List<Product> products      = productService.findByAnimalId(Long.valueOf(id));
//        model.addAttribute("products", products);
//        model.addAttribute("animals", animals);
//
//        return "10_products_animal";
//    }

/*    @GetMapping("/product/info/{id}")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("product", productService.findById(Long.valueOf(id)));
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals",animals);
        return "10_products_animal";
    }*/
}

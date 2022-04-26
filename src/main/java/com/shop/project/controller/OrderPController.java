package com.shop.project.controller;

import com.shop.project.domain.Animal;
import com.shop.project.domain.User;
import com.shop.project.service.AnimalService;
import com.shop.project.service.OrderPService;
import com.shop.project.service.ProductService;
import com.shop.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderPController
{
    @Autowired
    UserService userService;

    @Autowired
    OrderPService orderPService;

    AnimalService  animalService;
    ProductService productService;

    @Autowired
    public OrderPController(OrderPService orderPService)
    {
        this.orderPService = orderPService;
    }

    @GetMapping("/orders/{userId}")
    public String showOrdersFromUser(@PathVariable String userId, Model model)
    {
        model.addAttribute("orders", orderPService.findByUser(Long.valueOf(userId)));
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals",animals);
        return "userOrders";
    }

    @GetMapping("/orders")
    public String showOrdersFromUser(@PathVariable User user, Model model)
    {
        model.addAttribute("orders", orderPService.findByUser(Long.valueOf(user.getId())));
        return "userOrders";
    }

    @RequestMapping("/order/list")
    public ModelAndView usersList()
    {
        ModelAndView modelAndView = new ModelAndView("orders");
        List<User> users = userService.findAll();
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/order/{id}")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("participant",
                userService.findById(Long.valueOf(id)));
        return "userInfo";
    }

    @RequestMapping("/order/new")
    public String newParticipant(Model model)
    {
        model.addAttribute("user", new User());
        return "userForm";
    }

//    @RequestMapping("/user/update/{id}")
//    public String updateParticipant(@PathVariable String id, Model model)
//    {
//        model.addAttribute("participant",
//                userService.findById(Long.valueOf(id)));
//        return "userForm";
//    }

    @PostMapping("/order")
    public String saveOrUpdate(@ModelAttribute User user)
    {
        User savedUser = userService.save(user);
        return "redirect:/user/info/" + savedUser.getId();
    }
}

package com.shop.project.controller;

import com.shop.project.domain.User;
import com.shop.project.service.OrderPService;
import com.shop.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @Autowired
    OrderPService orderPService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping("/user/list")
    public ModelAndView usersList()
    {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = userService.findAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/user/info/{id}")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("user",
                userService.findById(Long.valueOf(id)));
        return "userInfo";
    }

    @RequestMapping("/user/new")
    public String newParticipant(Model model)
    {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @RequestMapping("/user/update/{id}")
    public String updateParticipant(@PathVariable String id, Model model)
    {
        model.addAttribute("user",
                userService.findById(Long.valueOf(id)));
        return "userForm";
    }

    @PostMapping("/user")
    public String saveOrUpdate(@ModelAttribute User user)
    {
        User savedUser = userService.save(user);
        return "redirect:/user/info/" + savedUser.getId();
    }
}




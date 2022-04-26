package com.shop.project.controller;

import com.shop.project.domain.Product;
import com.shop.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    ProductService productService;

//    @GetMapping("/fragments")
//    public String fragments(){ return "fragments"; }

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "00_login"; }

    @GetMapping("/login-error")
    public String loginError(Model model)
    {
        model.addAttribute("errorMessage","Invalid user or password");
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "accessDenied";
    }


    @RequestMapping({"", "/", "/index2"})
    public ModelAndView productsList()
    {
        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }
}

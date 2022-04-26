//package com.shop.project.controller;
//
//import com.shop.project.domain.Animal;
//import com.shop.project.domain.Product;
//import com.shop.project.domain.User;
//import com.shop.project.service.AnimalService;
//import com.shop.project.service.ProductService;
////import com.shop.project.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
////@Slf4j
//@Controller
//public class AccountController
//{
//    @Autowired
//    AnimalService animalService;
//    UserService userService;
//    ProductService productService;
//    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
//
//    @Autowired
//    public AccountController(AnimalService animalService, UserService userService, ProductService productService)
//    {
//        this.animalService = animalService;
//        this.userService = userService;
//        this.productService = productService;
//    }
//
////    @InitBinder
////    public void
//
//    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
//    public ModelAndView login()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Animal> animals = animalService.findAll();
//        modelAndView.setViewName("00_login");
//        modelAndView.addObject("animals",animals);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(Model model)
//    {
//        User user = new User();
//        List<Animal> animals = animalService.findAll();
//        model.addAttribute("user", user);
//        model.addAttribute("animals",animals);
//        return "01_register";
//
//    }
//
//    @PostMapping(value = "/register")
//    public String saveUserAfterRegister(@ModelAttribute User user,
//                                        BindingResult bindingResult)
//    {
//        log.info(user.toString());
//        if (bindingResult.hasErrors())
//        {
//            return "01_register";
//        }
//
//        User savedUser = userService.save(user);
//        return "redirect:/product/list" ;
//
//    }
//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public ModelAndView home()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<Product> products = productService.findAll();
//        List<Animal> animals = animalService.findAll();
//        modelAndView.addObject("products",products);
//        modelAndView.addObject("animals",animals);
//        modelAndView.setViewName("10_products"); // resources/template/home.html
//
//        return modelAndView;
//    }
//}

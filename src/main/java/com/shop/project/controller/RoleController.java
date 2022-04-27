package com.shop.project.controller;

import com.shop.project.domain.Product;
import com.shop.project.domain.ProductInfo;
import com.shop.project.domain.Role;
import com.shop.project.service.ProductService;
import com.shop.project.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll()
    {
        List<Role> roles= roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}

package com.shop.project.controller;

import com.shop.project.domain.Animal;
import com.shop.project.domain.Category;
import com.shop.project.domain.Product;
import com.shop.project.domain.ProductInfo;
import com.shop.project.service.AnimalService;
import com.shop.project.service.CategoryService;
import com.shop.project.service.ImageService;
import com.shop.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController
{
    @Autowired
    ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductInfoController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductInfo> getProduct(@RequestParam Long id)
    {
        Product product = productService.findById(id);
        ProductInfo productInfo = product.getProductInfo();
        logger.info("sunt in getProduct" + productInfo.getDescription());
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }
}

package com.shop.project.controller;

import com.shop.project.domain.Animal;
import com.shop.project.domain.Category;
import com.shop.project.domain.Product;
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
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    ProductService productService;

    @Autowired
    ImageService imageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AnimalService animalService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> productsList()
    {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProductById(@RequestParam Long id)
    {
        productService.deleteById(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK); //NO_CONTENT
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.save(product);
//        imageService.saveImageFile(Long.valueOf(savedProduct.getId()), file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
    {
        Product updated_product = productService.update(product);
        return new ResponseEntity<>(updated_product, HttpStatus.OK);
    }

    @GetMapping("/animal")
    public ResponseEntity<List<Product>> listByAnimalId(@PathVariable String id)
    {
        List<Product> products = productService.findByAnimalId(Long.valueOf(id));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> listByCategoryId(@PathVariable String id)
    {
        List<Product> products = productService.findByCategoryId(Long.valueOf(id));
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @PostMapping()
//    public String saveOrUpdate(@ModelAttribute Product product,
//                               BindingResult bindingResult,
//                               @RequestParam("imagefile") MultipartFile file)
//    {
//        if (bindingResult.hasErrors())
//        {
//            return "12_productform";
//        }
//
//        Product savedProduct = productService.save(product);
//        imageService.saveImageFile(Long.valueOf(savedProduct.getId()), file);
//        return "redirect:/products" ;
//    }
}

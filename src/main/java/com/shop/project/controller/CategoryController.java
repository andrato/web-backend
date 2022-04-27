package com.shop.project.controller;

import com.shop.project.domain.Category;
import com.shop.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> categoryList()
    {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByCategoryId(@RequestParam Long id)
    {
        categoryService.deleteById(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK); //NO_CONTENT
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addCategory(@RequestBody Category category)
    {
        Category savedProduct = categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        Category updated_cat = categoryService.update(category);
        return new ResponseEntity<>(updated_cat, HttpStatus.OK);

    }
}

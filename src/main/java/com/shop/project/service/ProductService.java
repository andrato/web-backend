package com.shop.project.service;

import com.shop.project.domain.Product;

import java.util.List;

public interface ProductService
{
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    Product update(Product product);
    void deleteById(Long id);
    List<Product> findByAnimalId(Long id);
    List<Product> findByCategoryId(Long id);
    List<Product> findByAnimalCategory(Long animalId, Long categoryId);
}

package com.shop.project.service;

import com.shop.project.domain.Product;
import com.shop.project.exception.EntityNotFoundException;
import com.shop.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        return productOptional.get();
    }

     @Override
     public Product save(Product product) {
         Product savedProduct = productRepository.save(product);
         return savedProduct;
     }

    @Override
    public void deleteById(Long id)
    {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }
        Product product = productOptional.get();

        productRepository.save(product);
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByAnimalId(Long id) {
        List<Product> products = productRepository.findByAnimalId(id);
        return products;
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        List<Product> products = productRepository.findByCategoryId(id);
        return products;
    }

    @Override
    public List<Product> findByAnimalCategory(Long animalId, Long categoryId) {
        List<Product> products = productRepository.findByAnimalCategory(animalId, categoryId);
        return products;
    }

    @Override
    public Product update(Product product) {
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            throw new EntityNotFoundException(String.format("There is no product with id=%s in the database!", product.getId().toString()));
        }
    }

}

package com.shop.project.service;

import com.shop.project.domain.Product;
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
    public List<Product> findAll()
    {
        List<Product> products = new LinkedList<>();
        productRepository.findAll().iterator().forEachRemaining(products::add);
        return products;
    }

    @Override
    public Product findById(Long id)
    {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }
        return productOptional.get();
    }

 /*   @Override
    public Product save(Product product)
    {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        Product savedProduct;
        if (!productOptional.isPresent())
        {
            savedProduct = productRepository.save(product);
        }
        else
        {
            savedProduct = productRepository.editProduct(productOptional.get().getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getProductInfo().getImage());
        }

        return savedProduct;
    }*/
     @Override
     public Product save(Product product)
     {
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
    public List<Product> findByAnimalId(Long id)
    {
        List<Product> products = productRepository.findByAnimalId(id);
        return products;
    }
}

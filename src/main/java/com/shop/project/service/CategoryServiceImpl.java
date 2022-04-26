package com.shop.project.service;

import com.shop.project.domain.Category;
import com.shop.project.exception.EntityNotFoundException;
import com.shop.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService
{
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id)
    {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }
        return categoryOptional.get();
    }

    @Override
    public Category save(Category category)
    {
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public void deleteById(Long id)
    {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent())
        {
            throw new RuntimeException("Category not found!");
        }
        Category category = categoryOptional.get();

        categoryRepository.save(category);
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return categoryRepository.save(category);
        } else {
            throw new EntityNotFoundException(String.format("There is no category with id=%s in the database!", category.getId().toString()));
        }
    }
}

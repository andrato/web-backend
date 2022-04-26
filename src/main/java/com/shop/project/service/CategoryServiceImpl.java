package com.shop.project.service;

import com.shop.project.domain.Category;
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
        List<Category> categories = new LinkedList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories;
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
}

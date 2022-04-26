package com.shop.project.service;

import com.shop.project.domain.Category;

import java.util.List;

public interface CategoryService
{
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}

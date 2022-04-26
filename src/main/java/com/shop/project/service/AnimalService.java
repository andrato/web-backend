package com.shop.project.service;

import com.shop.project.domain.Animal;

import java.util.List;

public interface AnimalService
{
    List<Animal> findAll();
    Animal findById(Long id);
    Animal save(Animal category);
    void deleteById(Long id);
}

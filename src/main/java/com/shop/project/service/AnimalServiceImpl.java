package com.shop.project.service;

import com.shop.project.domain.Animal;
import com.shop.project.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService
{
    AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @Override
    public List<Animal> findAll()
    {
        List<Animal> animals = new LinkedList<>();
        animalRepository.findAll().iterator().forEachRemaining(animals::add);
        return animals;
    }

    @Override
    public Animal findById(Long id)
    {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        if (!animalOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }
        return animalOptional.get();
    }

    @Override
    public Animal save(Animal category)
    {
        Animal savedAnimal = animalRepository.save(category);
        return savedAnimal;
    }

    @Override
    public void deleteById(Long id)
    {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        if (!animalOptional.isPresent())
        {
            throw new RuntimeException("Category not found!");
        }
        Animal animal = animalOptional.get();

        animalRepository.save(animal);
        animalRepository.deleteById(id);
    }
}

package com.shop.project.repository;

import com.shop.project.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query("select p from Product p where p.category.name = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);

    @Query("select p from Product p where p.animal.id = :animalId")
    List<Product> findByAnimalId(@Param("animalId") Long animalId);

    @Query("select p from Product p where p.animal.name = :animalName and p.category.name = :categoryName")
    List<Product> findByAnimalCategoryName(@Param("animalName") String animalName, @Param("categoryName") String categoryName );

    @Query("update Product p set p.name = :newName, p.price = :newPrice, p.quantity = :newQuantity, p.productInfo.image = :newImage where p.id = :id ")
    Product editProduct(@Param("id") Long id, @Param("newName") String name, @Param("newPrice") int price, @Param("newQuantity") Integer quantity, @Param("newImage") Byte[]  image);
}

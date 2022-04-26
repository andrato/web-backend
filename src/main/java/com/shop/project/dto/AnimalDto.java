package com.shop.project.dto;

import com.shop.project.domain.Product;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class AnimalDto {
    private Long    id;
    private String  name;

//    private List<Product> products;
}

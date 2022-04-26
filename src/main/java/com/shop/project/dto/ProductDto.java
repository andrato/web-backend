package com.shop.project.dto;

import com.shop.project.domain.Animal;
import com.shop.project.domain.Category;
import com.shop.project.domain.OrderP;
import com.shop.project.domain.ProductInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProductDto {
    private Long    id;
    private String  name;
    private int     price;
    private Integer quantity;

//    private ProductInfo productInfo;
//
//    private Category category;
//
//    private Animal animal;
//
//    private List<OrderP> orders;
}

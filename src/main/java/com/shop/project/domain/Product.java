package com.shop.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private int     price;
    private Integer quantity;

    @OneToOne (mappedBy = "product",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private ProductInfo productInfo;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Animal animal;

    @ManyToMany(mappedBy = "products")
    private List<OrderP> orders;

}

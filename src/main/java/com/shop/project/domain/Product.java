package com.shop.project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private int     price;
    private Integer quantity;

    @JsonBackReference(value="product_info")
    @OneToOne (mappedBy = "product",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private ProductInfo productInfo;

    @JsonBackReference(value="category_products")
    @ManyToOne (fetch = FetchType.LAZY)
    private Category category;

    @JsonBackReference(value="animal_products")
    @ManyToOne
    private Animal animal;

    @JsonBackReference(value="orders")
    @ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<OrderP> orders = new HashSet<>();


}

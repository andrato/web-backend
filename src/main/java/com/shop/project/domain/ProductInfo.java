package com.shop.project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Setter
@Getter
public class ProductInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    @Lob
    private Byte[]  image;

    @Max(200)
    private String  description;

    @JsonManagedReference(value="product_info")
    @OneToOne
    private Product product;
}

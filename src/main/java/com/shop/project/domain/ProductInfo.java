package com.shop.project.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    @Lob
    private Byte[]  image;
    private String  description;

    @OneToOne
    private Product product;
}

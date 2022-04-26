package com.shop.project.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private String  description;

    @OneToOne
    private Product product;
}

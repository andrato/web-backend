package com.shop.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;

    @OneToMany(mappedBy = "animal")
    private List<Product> products;
}

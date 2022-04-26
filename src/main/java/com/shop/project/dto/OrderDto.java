package com.shop.project.dto;

import com.shop.project.domain.Product;
import com.shop.project.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Data
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="add_date")
    private Date date;
    private boolean done = false;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_order",
            joinColumns         =@JoinColumn(name="order_id",referencedColumnName = "id"),
            inverseJoinColumns  =@JoinColumn(name="product_id",referencedColumnName="id"))
    private List<Product> products;
}

package com.shop.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Data
public class OrderP
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="add_date")
    private Date date;
    private boolean done = false;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "product_order",
            joinColumns         =@JoinColumn(name="order_id",referencedColumnName = "id"),
            inverseJoinColumns  =@JoinColumn(name="product_id",referencedColumnName="id"))
    private List<Product> products;
}

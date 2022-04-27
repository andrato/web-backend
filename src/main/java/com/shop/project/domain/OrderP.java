package com.shop.project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Setter
@Getter
public class OrderP
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="add_date")
    private Date date;
    private boolean done = false;

    @JsonBackReference(value="user_order")
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "product_order",
            joinColumns         =@JoinColumn(name="order_id",referencedColumnName = "id"),
            inverseJoinColumns  =@JoinColumn(name="product_id",referencedColumnName="id"))
    private List<Product> products;

    public void addProductToOrder(Product product, String email) {
        if(email == user.getEmail()) {
            products.add(product);
        }
    }
}

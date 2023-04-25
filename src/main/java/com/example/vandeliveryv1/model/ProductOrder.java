package com.example.vandeliveryv1.model;

import jakarta.persistence.*;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "prodid", referencedColumnName = "productid")
    private Product product;



}

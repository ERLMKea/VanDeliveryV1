package com.example.vandeliveryv1.controller;

import com.example.vandeliveryv1.model.Product;
import com.example.vandeliveryv1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRESTController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


}

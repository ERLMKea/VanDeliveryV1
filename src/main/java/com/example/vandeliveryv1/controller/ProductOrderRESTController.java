package com.example.vandeliveryv1.controller;

import com.example.vandeliveryv1.model.Product;
import com.example.vandeliveryv1.model.ProductOrder;
import com.example.vandeliveryv1.repository.ProductOrderRepository;
import com.example.vandeliveryv1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductOrderRESTController {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @GetMapping("/productorders")
    public List<ProductOrder> getProductOrders() {
        return productOrderRepository.findAll();
    }

    @PutMapping("/order")
    public ProductOrder updateOrder(@RequestBody ProductOrder order) {
        Optional<ProductOrder> po = productOrderRepository.findById(order.getId());
        if (po.isPresent()) {
            productOrderRepository.save(order);
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "orderlinje ikke fundet");
        }
        return order;
    }


    @PostMapping("/order")
    public ProductOrder addOrder(@RequestBody ProductOrder order) {
        try {
            productOrderRepository.save(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

}





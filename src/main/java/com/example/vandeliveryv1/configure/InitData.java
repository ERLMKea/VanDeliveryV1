package com.example.vandeliveryv1.configure;

import com.example.vandeliveryv1.model.Delivery;
import com.example.vandeliveryv1.model.Product;
import com.example.vandeliveryv1.model.ProductOrder;
import com.example.vandeliveryv1.repository.DeliveryRepository;
import com.example.vandeliveryv1.repository.ProductOrderRepository;
import com.example.vandeliveryv1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("Æble");
        product.setPrice(5.5);
        product.setWeight(150);
        productRepository.save(product);

        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(LocalDate.now());
        delivery.setWarehouse("W1");
        delivery.setDestination("Havnevej 2 4000 Roskilde");
        deliveryRepository.save(delivery);

        ProductOrder po = new ProductOrder();
        po.setProduct(product);
        po.setDelivery(delivery);
        po.setQuantity(10);
        productOrderRepository.save(po);

        product = new Product();
        product.setName("Banan");
        product.setPrice(5.5);
        product.setWeight(150);
        productRepository.save(product);

        po = new ProductOrder();
        po.setProduct(product);
        po.setDelivery(delivery);
        po.setQuantity(10);
        productOrderRepository.save(po);


    }

}

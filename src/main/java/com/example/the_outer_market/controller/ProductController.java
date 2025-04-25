package com.example.the_outer_market.controller;

import com.example.the_outer_market.model.Product;
import com.example.the_outer_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/reserve")
    public boolean reserveProduct(@RequestParam Long productId, @RequestParam int quantity) {
        return service.reserveProduct(productId, quantity);
    }

    @PostMapping("/confirm")
    public void confirmProduct(@RequestParam Long productId, @RequestParam int quantity) {
        service.confirmReservation(productId, quantity);
    }

    @PostMapping("/cancel")
    public void cancelProduct(@RequestParam Long productId, @RequestParam int quantity) {
        service.cancelReservation(productId, quantity);
    }
}

package com.example.the_outer_market.controller;

import com.example.the_outer_market.model.Product;
import com.example.the_outer_market.service.ProductRequest;
import com.example.the_outer_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/theoutermarket")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/reserve")
    public Long reserveProducts(@RequestBody List<ProductRequest> productRequests) {
        return service.reserveProducts(productRequests); // Return reservation ID
    }

    @PostMapping("/confirm")
    public boolean confirm(@RequestParam Long reservationId) {
        return service.confirmReservation(reservationId);
    }

    @PostMapping("/cancel")
    public boolean cancel(@RequestParam Long reservationId) {
        return service.cancelReservation(reservationId);
    }
}

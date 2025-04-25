package com.example.the_outer_market.service;

import com.example.the_outer_market.model.Product;
import com.example.the_outer_market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public boolean reserveProduct(Long productId, int quantity) {
        Product product = repository.findById(productId).orElse(null);
        if (product != null && product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            repository.save(product);
            return true;
        }
        return false;
    }

    public void confirmReservation(Long productId, int quantity) {
        // Reservation already decreased stock at reserve phase, nothing extra needed.
    }

    public void cancelReservation(Long productId, int quantity) {
        Product product = repository.findById(productId).orElse(null);
        if (product != null) {
            product.setStock(product.getStock() + quantity);
            repository.save(product);
        }
    }
}

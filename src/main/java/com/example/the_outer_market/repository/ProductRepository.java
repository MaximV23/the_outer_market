package com.example.the_outer_market.repository;

import com.example.the_outer_market.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

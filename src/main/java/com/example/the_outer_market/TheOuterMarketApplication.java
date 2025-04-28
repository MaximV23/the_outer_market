package com.example.the_outer_market;

import com.example.the_outer_market.model.Product;
import com.example.the_outer_market.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheOuterMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheOuterMarketApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return (args) -> {
        };
    }
}

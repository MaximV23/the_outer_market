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
    public CommandLineRunner loadData(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product("Sandcruiser", 1500000, 10));
            repository.save(new Product("Lightspeed 3000", 5000000, 3));
        };
    }
}

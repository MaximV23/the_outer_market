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
            repository.save(new Product("Starfarer Starter Kit", 249, 15));
            repository.save(new Product("Voidrunner Mini Drone", 129, 20));
            repository.save(new Product("Nebula Navigation Charts (Holo Edition)", 49, 30));
            repository.save(new Product("Quantum Cargo Crate (Mystery Box)", 89, 50));
            repository.save(new Product("Plasma Forge Toolkit", 199, 12));
            repository.save(new Product("Cryosleep Comfort Blanket", 79, 40));
            repository.save(new Product("Ion Thruster Desk Model", 59, 25));
            repository.save(new Product("Asteroid Miner Gloves", 39, 35));
            repository.save(new Product("Warp Core Power Bank (10,000 mAh)", 69, 40));
            repository.save(new Product("Galactic Trading Cards (Series 1)", 24, 100));
            repository.save(new Product("Zero-G Coffee Flask", 34, 45));
            repository.save(new Product("Outer Rim Survival Pack", 299, 10));
            repository.save(new Product("Cosmic Compass Pendant", 44, 60));
            repository.save(new Product("Deep Space Communication Beacon (Bluetooth Speaker)", 99, 18));
            repository.save(new Product("Terraformer’s Gardening Kit", 54, 20));

            // spaceships
            repository.save(new Product("Eclipse-Class Light Freighter", 35000, 2));
            repository.save(new Product("Nova Raider (Fast Attack Ship)", 54000, 1));
            repository.save(new Product("Wayfarer Scout Ship", 28000, 3));
            repository.save(new Product("Orion Hauler (Heavy Cargo Vessel)", 75000, 1));
            repository.save(new Product("Aetherwing Racer (Limited Edition)", 47000, 2));
            repository.save(new Product("Warden-IX Gunship (Retired Military Surplus)", 89000, 1));
            repository.save(new Product("Solarwind Courier (Stealth Model)", 32000, 4));

        };
    }
}

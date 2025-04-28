package com.example.the_outer_market.service;

import com.example.the_outer_market.model.Product;
import com.example.the_outer_market.model.Reservation;
import com.example.the_outer_market.model.ReservedItem;
import com.example.the_outer_market.repository.ProductRepository;
import com.example.the_outer_market.repository.ReservationRepository;
import com.example.the_outer_market.repository.ReservedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservedItemRepository reservedItemRepository;

    @Transactional
    public Long reserveProducts(List<ProductRequest> productRequests) {
        Reservation reservation = new Reservation();
        reservation = reservationRepository.save(reservation);

        for (ProductRequest req : productRequests) {
            Product product = productRepository.findById(req.getProductId()).orElseThrow(
                    () -> new RuntimeException("Product not found: " + req.getProductId())
            );

            if (product.getStock() < req.getQuantity()) {
                throw new RuntimeException("Insufficient stock for: " + product.getName());
            }

            product.setStock(product.getStock() - req.getQuantity());
            productRepository.save(product);

            ReservedItem item = new ReservedItem(req.getProductId(), req.getQuantity(), reservation);
            reservedItemRepository.save(item);
        }

        return reservation.getId();
    }

    @Transactional
    public boolean confirmReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            reservationRepository.delete(reservation); // Stock already adjusted during reserve
            return true;
        }
        return false;
    }

    @Transactional
    public boolean cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null) {
            for (ReservedItem item : reservation.getItems()) {
                Product product = productRepository.findById(item.getProductId()).orElse(null);
                if (product != null) {
                    product.setStock(product.getStock() + item.getQuantity());
                    productRepository.save(product);
                }
            }
            reservationRepository.delete(reservation);
            return true;
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

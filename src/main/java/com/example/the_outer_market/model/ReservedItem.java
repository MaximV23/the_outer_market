package com.example.the_outer_market.model;

import jakarta.persistence.*;

@Entity
public class ReservedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    public ReservedItem() {}

    public ReservedItem(Long productId, int quantity, Reservation reservation) {
        this.productId = productId;
        this.quantity = quantity;
        this.reservation = reservation;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public Reservation getReservation() { return reservation; }

    public void setId(Long id) { this.id = id; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setReservation(Reservation reservation) { this.reservation = reservation; }
}

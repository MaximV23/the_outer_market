package com.example.the_outer_market.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reservedAt;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservedItem> items = new ArrayList<>();

    public Reservation() {
        this.reservedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public LocalDateTime getReservedAt() { return reservedAt; }
    public List<ReservedItem> getItems() { return items; }

    public void setId(Long id) { this.id = id; }
    public void setReservedAt(LocalDateTime reservedAt) { this.reservedAt = reservedAt; }
    public void setItems(List<ReservedItem> items) { this.items = items; }
}

package com.example.the_outer_market.repository;

import com.example.the_outer_market.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

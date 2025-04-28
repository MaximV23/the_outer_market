package com.example.the_outer_market.repository;

import com.example.the_outer_market.model.ReservedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedItemRepository extends JpaRepository<ReservedItem, Long> {}

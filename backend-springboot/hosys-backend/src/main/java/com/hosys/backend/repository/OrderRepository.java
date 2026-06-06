package com.hosys.backend.repository;

import com.hosys.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    long countByStatus(String status);
}
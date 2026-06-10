package com.hosys.backend.repository;

import com.hosys.backend.entity.Order;
import com.hosys.backend.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    long countByStatus(OrderStatus status);

    List<Order> findByStatus(OrderStatus status);
}
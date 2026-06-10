package com.hosys.backend.repository;

import com.hosys.backend.entity.Bill;
import com.hosys.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByOrder(Order order);
}
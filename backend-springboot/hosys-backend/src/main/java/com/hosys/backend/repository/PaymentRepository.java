package com.hosys.backend.repository;

import com.hosys.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
     @Query("""
        SELECT COALESCE(SUM(p.amount), 0)
        FROM Payment p
        """)
    Long getTotalRevenue();
}
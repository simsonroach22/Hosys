package com.hosys.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    private String paymentMethod;

    private BigDecimal amount;

    private String paymentStatus;

    private String transactionReference;

    private LocalDateTime paidAt;
}
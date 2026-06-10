package com.hosys.backend.entity;

import com.hosys.backend.enums.TableStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurant_tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tableNumber;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status;
}
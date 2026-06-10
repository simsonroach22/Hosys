package com.hosys.backend.repository;

import com.hosys.backend.entity.RestaurantTable;
import com.hosys.backend.enums.TableStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository
        extends JpaRepository<RestaurantTable, Long> {

    List<RestaurantTable> findByStatus(TableStatus status);

    long countByStatus(TableStatus status);
}
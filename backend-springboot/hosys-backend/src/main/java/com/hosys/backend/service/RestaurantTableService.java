package com.hosys.backend.service;

import com.hosys.backend.entity.RestaurantTable;
import com.hosys.backend.repository.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public RestaurantTable saveTable(RestaurantTable table) {
        return tableRepository.save(table);
    }

    public List<RestaurantTable> getAvailableTables() {
        return tableRepository.findByStatus("AVAILABLE");
    }
}
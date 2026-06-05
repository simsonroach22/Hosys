package com.hosys.backend.controller;

import com.hosys.backend.entity.RestaurantTable;
import com.hosys.backend.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class RestaurantTableController {

    private final RestaurantTableService tableService;

    @GetMapping
    public List<RestaurantTable> getAllTables() {
        return tableService.getAllTables();
    }

    @PostMapping
    public RestaurantTable createTable(
            @RequestBody RestaurantTable table) {

        return tableService.saveTable(table);
    }

    @GetMapping("/available")
    public List<RestaurantTable> getAvailableTables() {
        return tableService.getAvailableTables();
    }
}
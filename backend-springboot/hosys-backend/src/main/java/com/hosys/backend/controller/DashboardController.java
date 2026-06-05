package com.hosys.backend.controller;

import com.hosys.backend.dto.DashboardSummary;
import com.hosys.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public DashboardSummary getDashboard() {
        return dashboardService.getSummary();
    }
}
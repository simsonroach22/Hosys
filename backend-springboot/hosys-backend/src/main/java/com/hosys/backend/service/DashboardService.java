package com.hosys.backend.service;

import com.hosys.backend.dto.DashboardSummary;
import com.hosys.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final UserRepository userRepository;
    private final RestaurantTableRepository tableRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public DashboardSummary getSummary() {

        return DashboardSummary.builder()
                .totalUsers(userRepository.count())
                .totalTables(tableRepository.count())
                .totalOrders(orderRepository.count())
                .totalRevenue(paymentRepository.getTotalRevenue())
                .build();
    }
}
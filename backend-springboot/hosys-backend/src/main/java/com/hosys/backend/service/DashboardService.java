package com.hosys.backend.service;

import com.hosys.backend.dto.DashboardSummary;
import com.hosys.backend.repository.OrderRepository;
import com.hosys.backend.repository.PaymentRepository;
import com.hosys.backend.repository.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final OrderRepository orderRepository;
    private final RestaurantTableRepository tableRepository;
    private final PaymentRepository paymentRepository;

    public DashboardSummary getSummary() {

        return DashboardSummary.builder()
                .totalOrders(orderRepository.count())
                .pendingOrders(orderRepository.countByStatus("PENDING"))
                .completedOrders(orderRepository.countByStatus("COMPLETED"))

                .totalTables(tableRepository.count())
                .availableTables(tableRepository.countByStatus("AVAILABLE"))
                .occupiedTables(tableRepository.countByStatus("OCCUPIED"))

                .totalRevenue(paymentRepository.getTotalRevenue())
                .build();
    }
}
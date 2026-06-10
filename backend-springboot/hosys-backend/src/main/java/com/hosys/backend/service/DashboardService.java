package com.hosys.backend.service;

import com.hosys.backend.dto.DashboardSummary;
import com.hosys.backend.enums.OrderStatus;
import com.hosys.backend.enums.TableStatus;
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
                .pendingOrders(orderRepository.countByStatus(OrderStatus.PENDING))
                .completedOrders(orderRepository.countByStatus(OrderStatus.COMPLETED))

                .totalTables(tableRepository.count())
                .availableTables(tableRepository.countByStatus(TableStatus.AVAILABLE))
                .occupiedTables(tableRepository.countByStatus(TableStatus.OCCUPIED))

                .totalRevenue(paymentRepository.getTotalRevenue())
                .build();
    }
}
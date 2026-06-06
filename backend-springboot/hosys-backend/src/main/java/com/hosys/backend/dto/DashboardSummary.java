package com.hosys.backend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardSummary {

    private Long totalOrders;
    private Long pendingOrders;
    private Long completedOrders;

    private Long totalTables;
    private Long availableTables;
    private Long occupiedTables;

    private BigDecimal totalRevenue;
}
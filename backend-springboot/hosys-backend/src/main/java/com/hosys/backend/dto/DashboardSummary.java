package com.hosys.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardSummary {

    private Long totalUsers;

    private Long totalTables;

    private Long totalOrders;

    private Long totalRevenue;
}
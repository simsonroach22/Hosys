package com.hosys.backend.controller;

import com.hosys.backend.entity.Order;
import com.hosys.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/pending")
    public List<Order> pendingOrders() {
        return orderService.getPendingOrders();
    }

    @GetMapping("/ready")
    public List<Order> readyOrders() {
        return orderService.getReadyOrders();
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return orderService.updateStatus(id, status);
    }
}
package com.hosys.backend.controller;

import com.hosys.backend.entity.OrderItem;
import com.hosys.backend.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @PostMapping
    public OrderItem createOrderItem(
            @RequestBody OrderItem orderItem) {

        return orderItemService.saveOrderItem(orderItem);
    }
}
package com.hosys.backend.service;

import com.hosys.backend.entity.Order;
import com.hosys.backend.exception.ResourceNotFoundException;
import com.hosys.backend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getPendingOrders() {
        return orderRepository.findByStatus("PENDING");
    }

    public List<Order> getReadyOrders() {
        return orderRepository.findByStatus("READY");
    }

    public Order updateStatus(Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }

    
}
package com.hosys.backend.service;

import com.hosys.backend.entity.Bill;
import com.hosys.backend.entity.Order;
import com.hosys.backend.entity.Payment;
import com.hosys.backend.entity.RestaurantTable;
import com.hosys.backend.enums.OrderStatus;
import com.hosys.backend.enums.PaymentStatus;
import com.hosys.backend.enums.TableStatus;
import com.hosys.backend.repository.BillRepository;
import com.hosys.backend.repository.OrderRepository;
import com.hosys.backend.repository.PaymentRepository;
import com.hosys.backend.repository.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final RestaurantTableRepository tableRepository;
    private final BillRepository billRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) {

        System.out.println("PAYMENT SERVICE EXECUTED");

        payment.setPaidAt(LocalDateTime.now());

        Payment savedPayment = paymentRepository.save(payment);

        if (savedPayment.getPaymentStatus() == PaymentStatus.PAID) {

            Bill bill = billRepository.findById(
                    savedPayment.getBill().getId())
                    .orElseThrow();

            Order order = bill.getOrder();

            order.setStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);

            RestaurantTable table = order.getTable();

            if (table != null) {
                table.setStatus(TableStatus.AVAILABLE);
                tableRepository.save(table);
            }

        }

        return savedPayment;
    }
}
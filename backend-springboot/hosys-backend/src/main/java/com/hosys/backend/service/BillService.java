package com.hosys.backend.service;

import com.hosys.backend.entity.Bill;
import com.hosys.backend.entity.Order;
import com.hosys.backend.entity.OrderItem;
import com.hosys.backend.repository.BillRepository;
import com.hosys.backend.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final OrderItemRepository orderItemRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill saveBill(Bill bill) {

        Order order = bill.getOrder();

        List<OrderItem> items =
                orderItemRepository.findByOrder(order);

        BigDecimal subtotal = items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = subtotal.multiply(
                BigDecimal.valueOf(0.05));

        BigDecimal totalAmount = subtotal.add(tax);

        bill.setSubtotal(subtotal);
        bill.setTax(tax);
        bill.setTotalAmount(totalAmount);

        return billRepository.save(bill);
    }
}
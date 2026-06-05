package com.hosys.backend.service;

import com.hosys.backend.entity.Bill;
import com.hosys.backend.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }
}
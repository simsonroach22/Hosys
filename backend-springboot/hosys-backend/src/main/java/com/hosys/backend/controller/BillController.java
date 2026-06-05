package com.hosys.backend.controller;

import com.hosys.backend.entity.Bill;
import com.hosys.backend.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.saveBill(bill);
    }
}
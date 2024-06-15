package com.speingboot.loanService.controller;

import com.speingboot.loanService.dto.LoanDto;
import com.speingboot.loanService.model.Loan;
import com.speingboot.loanService.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody LoanDto loanDto) {
        return ResponseEntity.ok(loanService.addLoan(loanDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable UUID id) {
        return ResponseEntity.ok(loanService.getLoan(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable UUID id, @RequestBody LoanDto loanDto) {
        return ResponseEntity.ok(loanService.updateLoan(id, loanDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable UUID id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
}

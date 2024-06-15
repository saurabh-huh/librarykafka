package com.speingboot.loanService.service;

import com.speingboot.loanService.dto.LoanDto;
import com.speingboot.loanService.model.Loan;
import com.speingboot.loanService.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan addLoan(LoanDto loanDto) {
        Loan loan = new Loan();
        loan.setBookId(loanDto.getBookId());
        loan.setMemberId(loanDto.getMemberId());
        loan.setLoanDate(loanDto.getLoanDate());
        loan.setReturnDate(loanDto.getReturnDate());
        return loanRepository.save(loan);
    }

    public Loan getLoan(UUID id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public Loan updateLoan(UUID id, LoanDto loanDto) {
        Loan loan = getLoan(id);
        loan.setBookId(loanDto.getBookId());
        loan.setMemberId(loanDto.getMemberId());
        loan.setLoanDate(loanDto.getLoanDate());
        loan.setReturnDate(loanDto.getReturnDate());
        return loanRepository.save(loan);
    }

    public void deleteLoan(UUID id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}

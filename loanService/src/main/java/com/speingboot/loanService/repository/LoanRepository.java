package com.speingboot.loanService.repository;

import com.speingboot.loanService.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface LoanRepository extends MongoRepository<Loan, UUID> {
    List<Loan> findByReturnDateBefore(Date date);
}

package com.speingboot.loanService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private UUID bookId;
    private UUID memberId;
    private Date loanDate;
    private Date returnDate;
}

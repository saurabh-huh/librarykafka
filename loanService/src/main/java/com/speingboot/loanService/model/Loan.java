package com.speingboot.loanService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;


@Document(collection = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    private UUID id = UUID.randomUUID();
    private UUID bookId;
    private UUID memberId;
    private Date loanDate;
    private Date returnDate;
}

package com.speingboot.loanService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverdueNotificationDto {
    private UUID loanId;
    private UUID memberId;
    private UUID bookId;
    private String message;
}

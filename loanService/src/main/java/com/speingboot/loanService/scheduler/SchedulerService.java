package com.speingboot.loanService.scheduler;

import com.speingboot.loanService.dto.OverdueNotificationDto;
import com.speingboot.loanService.model.Loan;
import com.speingboot.loanService.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor


@Component
public class SchedulerService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private KafkaTemplate<String, OverdueNotificationDto> kafkaTemplate;


    @Scheduled(fixedRate = 60000) // This cron expression means midnight every day
    public void checkForOverdueBooks() {
        List<Loan> overdueLoans = loanRepository.findByReturnDateBefore(new Date());
        for (Loan loan : overdueLoans) {
            OverdueNotificationDto notification = new OverdueNotificationDto();
            notification.setLoanId(loan.getId());
            notification.setMemberId(loan.getMemberId());
            notification.setBookId(loan.getBookId());
            notification.setMessage("The loan with ID " + loan.getId() + " is overdue.");

            kafkaTemplate.send("loan-notification", notification);
        }
    }

}

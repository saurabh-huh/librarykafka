package com.speingboot.notificationService.service;

import com.google.gson.Gson;
import com.speingboot.notificationService.Repository.MemberRepository;
import com.speingboot.notificationService.dto.OverdueNotificationDto;
import com.speingboot.notificationService.emailConfig.EmailSender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class NotificationService {

    @Autowired
    private MemberRepository memberRepository;

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    @KafkaListener(topics = "loan-notification", groupId = "notification-group")
    public void processOverdueNotification(String message) {
        OverdueNotificationDto notification = new Gson().fromJson(message, OverdueNotificationDto.class);

        System.out.println("Sending notification for overdue loan: " + notification.getMessage());
        // Here We can add logic to send an actual email notification

        EmailSender emailSender = new EmailSender(mailSender);
        // Call the sendEmail method to send an email

        String recipientEmail = memberRepository.findById(notification.getMemberId()).get().getEmail();
        String subject = "Over of the book";
        String content = "<p>Hello,</p><p>Please submit book.</p>";

        try {
            emailSender.sendEmail(recipientEmail, subject, content);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException( e.getMessage());
        }


    }
}

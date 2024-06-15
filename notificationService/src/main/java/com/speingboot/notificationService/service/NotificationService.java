package com.speingboot.notificationService.service;

import com.google.gson.Gson;
import com.speingboot.notificationService.dto.OverdueNotificationDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @KafkaListener(topics = "loan-notifications", groupId = "notification-group")
    public void processOverdueNotification(String message) {
        OverdueNotificationDto notification = new Gson().fromJson(message, OverdueNotificationDto.class);
        System.out.println("Sending notification for overdue loan: " + notification.getMessage());
        // Here We can add logic to send an actual email notification


    }
}

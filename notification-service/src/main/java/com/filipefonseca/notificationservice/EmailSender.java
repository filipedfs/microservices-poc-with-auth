package com.filipefonseca.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender {
    public void sendEmail(String orderNumber) {
        log.info("Sending email to customer for order number {}.", orderNumber);
        log.info("Email sent to customer for order number {}.", orderNumber);
    }
}

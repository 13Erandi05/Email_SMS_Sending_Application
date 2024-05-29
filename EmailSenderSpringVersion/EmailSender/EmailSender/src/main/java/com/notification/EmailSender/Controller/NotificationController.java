package com.notification.EmailSender.Controller;

import com.notification.EmailSender.Entity.Customer;
import com.notification.EmailSender.Service.CustomerServices;
import com.notification.EmailSender.Service.NotificationSenderServices;
import com.notification.EmailSender.Service.NotificationServices;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController {
    @Autowired
    private CustomerServices customerService;

    @Autowired
    private NotificationServices notificationService;

    @Autowired
    private NotificationSenderServices notificationSenderService;

    @GetMapping("/sendNotification")
    public String sendNotification(@RequestParam @NotNull String notificationType) {
        Customer customer = customerService.getRandomCustomer();

        // Get the message for the notification type
        String message = notificationService.getAllNotificationMessages().get(notificationType);
        // Send notification
        notificationSenderService.sendNotification(customer, message);

        return notificationType+" notification has been Sent to Customer!!!";
    }
}
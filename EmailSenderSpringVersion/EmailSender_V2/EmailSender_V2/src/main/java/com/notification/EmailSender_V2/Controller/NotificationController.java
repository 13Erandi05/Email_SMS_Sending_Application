package com.notification.EmailSender_V2.Controller;


import com.notification.EmailSender_V2.Entity.Customer;
import com.notification.EmailSender_V2.Services.ICustomerServices;
import com.notification.EmailSender_V2.Services.INotificationMethod;
import com.notification.EmailSender_V2.Services.INotificationServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @Autowired
    private ICustomerServices customerService;

    @Autowired
    private INotificationServices notificationService;

    @Qualifier("gmailNotification")
    @Autowired
    private INotificationMethod notificationMethod;

    @GetMapping("/sendNotification")
    public String sendNotification(@RequestParam @NotNull String notificationType) {
        Customer customer = customerService.getRandomCustomer();

        // Get the message for the notification type
        String message = notificationService.getAllNotificationMessages().get(notificationType);
        // Send notification
        notificationMethod.sendNotification(customer.getName(), message);

        return notificationType+" notification has been Sent to Customer!!!";
    }
}
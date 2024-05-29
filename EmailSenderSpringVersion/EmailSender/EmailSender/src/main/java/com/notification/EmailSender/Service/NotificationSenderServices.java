package com.notification.EmailSender.Service;


import com.notification.EmailSender.Entity.Customer;

public interface NotificationSenderServices {
    void sendNotification(Customer customer, String message);
}

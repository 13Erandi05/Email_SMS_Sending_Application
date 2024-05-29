package com.notification.EmailSender_V2.Services;

public interface INotificationMethod {
    void sendNotification(String recipient, String message);
}

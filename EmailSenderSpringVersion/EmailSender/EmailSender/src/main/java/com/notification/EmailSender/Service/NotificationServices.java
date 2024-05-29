package com.notification.EmailSender.Service;

import java.util.Map;

public interface NotificationServices {
    Map<String, String> getAllNotificationMessages();
    void editMessage(String notificationType, String newMessage);
}

package com.notification.EmailSender_V2.Services;

import java.util.Map;

public interface INotificationServices {
    Map<String, String> getAllNotificationMessages();
    void editMessage(String notificationType, String newMessage);
}

package com.notification.EmailSender.Service;

import com.notification.EmailSender.Entity.Notification;
import com.notification.EmailSender.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServicesImpl implements NotificationServices{
    private final Map<String, String> notificationMessages = new HashMap<>();
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Map<String, String> getAllNotificationMessages() {
        List<Notification> notifications = notificationRepository.findAll();
        for (Notification notification : notifications) {
            notificationMessages.put(notification.getType(), notification.getMessageBody());
        }

        return notificationMessages;
    }

    @Override
    public void editMessage(String notificationType, String newMessage) {
        notificationMessages.put(notificationType, newMessage);
    }
}

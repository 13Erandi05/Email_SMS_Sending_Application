package com.notification.EmailSender_V2.Services;

import com.notification.EmailSender_V2.Entity.Notification;
import com.notification.EmailSender_V2.Repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServicesImpl implements INotificationServices {
    private final Map<String, String> notificationMessages = new HashMap<>();
    @Autowired
    private INotificationRepository notificationRepository;

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

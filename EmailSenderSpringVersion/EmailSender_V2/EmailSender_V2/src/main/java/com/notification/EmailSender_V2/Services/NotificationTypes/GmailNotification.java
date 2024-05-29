package com.notification.EmailSender_V2.Services.NotificationTypes;

import com.notification.EmailSender_V2.Services.INotificationMethod;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailNotification implements INotificationMethod {
    private JavaMailSender javaMailSender;
    @Override
    public void sendNotification(String recipient, String message) {
        // Use JavaMail API
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recipient);

        msg.setSubject("This is an Notification Email");
        msg.setText(message);

        javaMailSender.send(msg);
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

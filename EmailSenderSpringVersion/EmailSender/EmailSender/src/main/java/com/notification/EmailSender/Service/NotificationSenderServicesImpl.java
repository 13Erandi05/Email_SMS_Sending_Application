package com.notification.EmailSender.Service;


import com.notification.EmailSender.Entity.Customer;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderServicesImpl implements NotificationSenderServices{
    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendNotification(Customer customer, String message) {
        String preference = customer.getNotificationPreference();

        switch (preference) {
            case "Email":
                sendEmail(customer.getEmail(), message);
                break;
            case "Phone":
                sendTextMessage(customer.getPhoneNumber(), message);
                break;
            case "Both":
                sendEmail(customer.getEmail(), message);
                sendTextMessage(customer.getPhoneNumber(), message);
                break;
            default:
                System.out.println("Unsupported notification preference: " + preference);
        }
    }

    private void sendEmail(String email, String message) {
        // Use JavaMail API
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("This is an Notification Email");
        msg.setText(message);

        javaMailSender.send(msg);
        System.out.println("Sending email to " + email + ": " + message);
    }

    private void sendTextMessage(String phoneNumber, String message) {
        // Use Twilio SMS gateway
        Twilio.init(twilioAccountSid, twilioAuthToken);

        Message twilioMessage = Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber(twilioPhoneNumber),
                        message)
                .create();

        System.out.println("Sending text message to " + phoneNumber + ": " + message);

    }
}

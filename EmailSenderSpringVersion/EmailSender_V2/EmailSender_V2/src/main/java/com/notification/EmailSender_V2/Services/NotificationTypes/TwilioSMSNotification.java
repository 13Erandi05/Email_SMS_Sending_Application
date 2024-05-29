package com.notification.EmailSender_V2.Services.NotificationTypes;

import com.notification.EmailSender_V2.Services.INotificationMethod;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSMSNotification implements INotificationMethod {
    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Override
    public void sendNotification(String recipient, String message) {
        // Use Twilio SMS gateway
        Twilio.init(twilioAccountSid, twilioAuthToken);

        Message twilioMessage = Message.creator(
                        new PhoneNumber(recipient),
                        new PhoneNumber(twilioPhoneNumber),
                        message)
                .create();

        System.out.println("Sending text message to " + recipient + ": " + message);
    }
}

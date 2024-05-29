package com.notification.EmailSender_V2.Services;

import com.notification.EmailSender_V2.Entity.Customer;
import com.notification.EmailSender_V2.Services.NotificationTypes.GmailNotification;
import com.notification.EmailSender_V2.Services.NotificationTypes.TwilioSMSNotification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotificationSenderService{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    INotificationMethod notificationMethod;
    String emailSendingMethod;
    String smsSendingMethod;
    public void sendNotification(Customer customer, String message) throws IOException {
        String preference = customer.getNotificationPreference();

        switch (preference) {
            case "Email":
                if (notificationMethod == null) {
                    System.out.println("Please, select a email message Sending method:" + "\n" +
                            "1 - GmailService" + "\n");
                    emailSendingMethod = reader.readLine();

                    if (emailSendingMethod.equals("1")) {
                        notificationMethod = new GmailNotification();
                    }
                    //Add other email Notification methods
                    notificationMethod.sendNotification(customer.getEmail(),message);
                }
                break;
            case "Phone":
                if (notificationMethod == null) {
                    System.out.println("Please, select a text message Sending method:" + "\n" +
                            "1 - TwilioService" + "\n");
                    smsSendingMethod = reader.readLine();

                    if (smsSendingMethod.equals("1")) {
                        notificationMethod = new TwilioSMSNotification();
                    }
                    //Add other SMS Notification methods
                    notificationMethod.sendNotification(customer.getPhoneNumber(),message);
                }
                break;
            case "Both":
                if (notificationMethod == null) {
                    System.out.println("Please, select a email message Sending method:" + "\n" +
                            "1 - GmailService" + "\n");
                    emailSendingMethod = reader.readLine();
                    System.out.println("Please, select a text message Sending method:" + "\n" +
                            "1 - TwilioService" + "\n");
                    smsSendingMethod = reader.readLine();

                    if (emailSendingMethod.equals("1")) {
                        notificationMethod = new GmailNotification();
                    }
                    //Add other email Notification methods
                    notificationMethod.sendNotification(customer.getEmail(),message);



                    if (smsSendingMethod.equals("1")) {
                        notificationMethod = new TwilioSMSNotification();
                    }
                    //Add other SMS Notification methods
                    notificationMethod.sendNotification(customer.getPhoneNumber(),message);

                }
                break;
            default:
                System.out.println("Unsupported notification preference: " + preference);
        }
    }
}

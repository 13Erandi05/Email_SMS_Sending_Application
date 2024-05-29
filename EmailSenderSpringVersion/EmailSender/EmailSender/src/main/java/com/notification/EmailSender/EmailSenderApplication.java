package com.notification.EmailSender;

import com.notification.EmailSender.Controller.NotificationController;
import com.notification.EmailSender.Service.CustomerServices;
import com.notification.EmailSender.Service.CustomerServicesImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

@SpringBootApplication
public class EmailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}

}

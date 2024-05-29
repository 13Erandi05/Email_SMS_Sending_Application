package com.notification.EmailSender.Service;

import com.notification.EmailSender.Entity.Customer;
import java.util.List;

public interface CustomerServices {
    List<Customer> getAllCustomers();
    Customer getRandomCustomer();
}

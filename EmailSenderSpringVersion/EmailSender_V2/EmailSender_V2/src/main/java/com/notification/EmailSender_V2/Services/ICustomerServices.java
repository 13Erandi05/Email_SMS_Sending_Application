package com.notification.EmailSender_V2.Services;

import com.notification.EmailSender_V2.Entity.Customer;
import java.util.List;

public interface ICustomerServices {
    List<Customer> getAllCustomers();
    Customer getRandomCustomer();
}

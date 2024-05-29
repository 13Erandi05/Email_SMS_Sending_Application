package com.notification.EmailSender_V2.Services;


import com.notification.EmailSender_V2.Entity.Customer;
import com.notification.EmailSender_V2.Repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerServicesImpl implements ICustomerServices {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerServicesImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getRandomCustomer() {
        List<Customer> customers = getAllCustomers();
        return customers.get(new Random().nextInt(customers.size()));
    }
}

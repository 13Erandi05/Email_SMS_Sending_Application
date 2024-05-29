package com.notification.EmailSender.Service;


import com.notification.EmailSender.Entity.Customer;
import com.notification.EmailSender.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomerServicesImpl implements CustomerServices{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServicesImpl(CustomerRepository customerRepository) {
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

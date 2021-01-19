package com.accenture.bootcamp.onlinestore.project.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    final private CustomerMapper mapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.mapper = customerMapper;
    }

    public void createCustomer(Customer customer) {
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
        customer.setAddress(customer.getAddress());
        customer.setPhoneNumber(customer.getPhoneNumber());
        mapper.createCustomer(customer);
    }
}

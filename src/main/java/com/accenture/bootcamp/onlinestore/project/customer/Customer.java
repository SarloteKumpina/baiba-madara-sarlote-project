package com.accenture.bootcamp.onlinestore.project.customer;

import com.accenture.bootcamp.onlinestore.project.orders.Order;

import java.sql.Timestamp;

public class Customer extends Order {

    //create TABLE customers (
    //    id bigint(20) NOT NULL AUTO_INCREMENT,
    //    first_name varchar(255) NOT NULL,
    //    last_name varchar(255) NOT NULL,
    //    phone_number varchar (255) NOT NULL,
    //    email varchar(255) NOT NULL,
    //    address varchar(255) NOT NULL,
    //    PRIMARY KEY (id)
    //);

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;


    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

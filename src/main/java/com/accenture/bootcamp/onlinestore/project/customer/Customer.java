package com.accenture.bootcamp.onlinestore.project.customer;

import com.accenture.bootcamp.onlinestore.project.orders.Order;

import java.math.BigDecimal;

public class Customer extends Order {

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String statusName;
    private String statusId;
    private BigDecimal orderTotalSum;

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

    public String getStatusName() {
        return statusName;
    }
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int getStatusId() {
        return super.getStatusId();
    }

    @Override
    public void setStatusId(int statusId) {
        super.setStatusId(statusId);
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public BigDecimal getOrderTotalSum() {
        return orderTotalSum;
    }

    public void setOrderTotalSum(BigDecimal orderTotalSum) {
        this.orderTotalSum = orderTotalSum;
    }
}

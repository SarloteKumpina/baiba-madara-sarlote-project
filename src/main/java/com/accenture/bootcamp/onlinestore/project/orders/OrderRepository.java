package com.accenture.bootcamp.onlinestore.project.orders;

import java.util.List;

public interface OrderRepository {

    Order findOrderById(long id);

    //Order findOrderByCustomerId(long customerId);

    List<Order> findAll();

    void delete(long id);
}

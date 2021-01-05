package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;

import java.util.List;
import java.sql.Timestamp;

public interface OrderRepository {

    Order findOrderById(long id);

    Order findOrderByCustomerId(long customerId);

    Order findOrderByTime(Timestamp orderTime);

    List<Order> findAll();

    void delete(long id);

    List <OrderProduct> findProductListByOrderId();
}

package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {

    private final OrderMapper mapper;

    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public List<Customer> getAllOrders() {
        return mapper.getAllOrders();
    }

    public Order findOrderById(Long id) {
        Customer order = mapper.findOrderById(id);
        if (order == null) {
            throw new NotFoundException("Order with id " + id + " doesn't exist");
        }
        return order;
    }

    public Order updateStatusToApproved(Long id) {
        Order existing = findOrderById(id);
        existing.setStatusId(findOrderById(id).getStatusId());
        return existing;
    }


   /* public void delete(long id) {
        mapper.delete(id);
    }*/


   /* public Order findOrderById(long id) {
        Order order = mapper.findOrderById(id);
        if (order == null) {
            throw new NotFoundException("Order with id " + id + " doesn't exist");
        }
        return order;
    }

    @Override
    public Order findOrderByCustomerId(long customerId) {
        Order order = mapper.findOrderByCustomerId(customerId);
        if (order == null) {
            throw new NotFoundException("Order with customer id " + customerId + " doesn't exist");
        }
        return order;
    }

    @Override
    public Order findOrderByTime(Timestamp orderTime) {
        Order order = mapper.findOrderByTime(orderTime);
        if (order == null) {
            throw new NotFoundException("Order with order time " + orderTime + " doesn't exist");
        }
        return order;
    }

    @Override
    public List<OrderProduct> findProductListByOrderId() {
        return mapper.findProductListByOrderId();
    }*/
}

package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

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

    public List<OrderStatus> findAllStatuses() {return mapper.findAllStatuses();}

    public Order update(Long id, Order order) {
        Order existing = findOrderById(id);
        existing.setStatusId(order.getStatusId());
        mapper.update(existing);
        return existing;
    }

}

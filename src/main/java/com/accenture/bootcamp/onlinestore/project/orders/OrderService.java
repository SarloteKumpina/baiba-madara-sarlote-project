package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderRepository{

    private final OrderMapper mapper;

    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Order findOrderById(long id) {
        Order order = mapper.findOrderById(id);
        if (order == null) {
            throw new NotFoundException("Order with id " + id + " doesn't exist");
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return mapper.findAll();
    }

    @Override
    public void delete(long id) {
    }
}

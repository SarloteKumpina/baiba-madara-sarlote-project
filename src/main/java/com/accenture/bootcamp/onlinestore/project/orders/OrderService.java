package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends Order {

    private final OrderMapper mapper;

    public OrderService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public List<Order> getAllOrders() {
        return mapper.getAllOrders();
    }

    public Order findOrderById(Long id) {
        Order order = mapper.findOrderById(id);
        if (order == null) {
            throw new NotFoundException("Order with id " + id + " doesn't exist");
        }
        return order;
    }

    public List<OrderStatus> findAllStatuses() {return mapper.findAllStatuses();}

    public Order updateOrder(Long id, Order order) {
        Order existing = findOrderById(id);
        existing.setStatusId(order.getStatusId());
        mapper.updateStatus(existing);
        return existing;
    }

    public Order createOrder(Order order) {
        mapper.insertCustomerDetails(order);
        mapper.insertOrderInfo(order);
        mapper.insertOrdersProducts(order);
        return order;
    }

}

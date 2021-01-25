package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderMapper mapper;

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

    public List<Order> orderedProducts(Long id) {
        return mapper.orderedProducts(id);
    }

    public List<Order> findAllStatuses() {
        return mapper.findAllStatuses();
    }

    public Order updateOrderCustomerId(Long id, Long customerId) {
        Order existing = findOrderById(id);
        existing.setCustomerId(customerId);
        mapper.updateOrderCustomerId(existing);
        return existing;
    }

    public Order updateOrderStatus(Long id, Integer statusId, Order order) {
        Order existing = findOrderById(id);
        existing.setStatusId(order.getStatusId());
        mapper.updateOrderStatus(existing);
        return existing;
    }

    public Order createNewOrder(Integer statusId, String userId) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setStatusId(statusId);
        order.setUserId(userId);
        mapper.createOrder(order);
        return order;
    }

    public Long findOrderIdByUserId(String userId) {
        return mapper.findOrderIdByUserId(userId);
    }

    public Order findOrderByUserIdAndStatusId(String userId, Integer statusId) {
        return mapper.findOrderByUserIdAndStatusId(userId, statusId);
    }

    public Long findOrderIdByUserIdWhereStatusIsShoppingCart(String userId, Integer statusId) {
        return mapper.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, statusId);
    }

    public boolean userHasOrderWithStatusShoppingCart(String userId, Integer statusId) {
        Long orderId = mapper.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, statusId);
        return orderId != null;
    }

    public Order updateOrderStatusToPending(Long id, Integer statusId, Order order) {
        order.setStatusId(statusId);
        mapper.updateOrderStatusToPending(order);
        return order;
    }

    public Order minusFromStock(Long id, Long productId, Order order) {
        List<Order> orderedProducts = mapper.orderedProducts(id);
        for (Order product : orderedProducts) {
            int stockUpdate = product.getStock() - product.getQuantity();
            productId = product.getProductId();
            product.setStock(stockUpdate);
            mapper.updateProductStock(product);
        }
        return order;
    }
}
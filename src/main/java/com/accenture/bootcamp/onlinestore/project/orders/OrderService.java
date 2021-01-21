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

    public Order updateOrderCustomerId(Long id, Long customerId, Order order) {
        Order existing = findOrderById(id);
        existing.setCustomerId(order.getCustomerId());
        mapper.updateOrderCustomerId(existing);
        return order;
    }

    public Order updateOrderStatus(Long id, int statusId, Order order) {
        Order existing = findOrderById(id);
        existing.setStatusId(order.getStatusId());
        mapper.updateOrderStatus(existing);
        return existing;
    }

    public Order createNewOrder(int statusId, String userId) {
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

    public Order findOrderByUserIdAndStatusId(String userId, int statusId) {
        return mapper.findOrderByUserIdAndStatusId(userId, statusId);
    }

    public Long findOrderIdByUserIdWhereStatusIsShoppingCart(String userId, int statusId) {
        return mapper.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, statusId);
    }

    public boolean userHasOrderWithStatusShoppingCart(String userId, int statusId) {
        Long orderId = mapper.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, statusId);
        return orderId != null;
    }

    public Order updateOrderStatusToPending(Long id, int statusId, Order order) {
        order.setStatusId(statusId);
        mapper.updateOrderStatusToPending(order);
        return order;
    }

    //returns true if we have enough products in stock
    //compare ordered product quantity with product stock quantity
    //for each product in this particular order
//        if (orderService.verifyProductCount(order.getId())) {
//            return;
//        }

    public boolean verifyProductCount(Long id) {
        List<Order> orderedProducts = mapper.orderedProducts(id);
        for (Order product : orderedProducts) {
            if (product.getQuantity() < product.getStock()) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public int minusFromStock(Long id, int stockUpdate) {
        List<Order> orderedProducts = mapper.orderedProducts(id);
        for (Order product : orderedProducts) {
            stockUpdate = product.getStock() - product.getQuantity();
            product.setStock(stockUpdate);
        }
        return stockUpdate;
    }
}
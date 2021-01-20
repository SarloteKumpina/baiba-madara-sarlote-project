package com.accenture.bootcamp.onlinestore.project.orders;
import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProduct;
import com.accenture.bootcamp.onlinestore.project.products.ProductMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderMapper mapper;
    private final ProductMapper productMapper;

    public OrderService(OrderMapper mapper, ProductMapper productMapper) {
        this.mapper = mapper;
        this.productMapper = productMapper;
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

    public OrderProduct insertIntoOrderProducts(Long productId, int quantity, Long id) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProductId(productId);
        orderProduct.setQuantity(quantity);
        orderProduct.setOrderId(id);
        mapper.insertIntoOrderProducts(orderProduct);
        return orderProduct;
    }

    public boolean userHasOrderWithStatusShoppingCart(String userId, int statusId) {
        Long orderId = mapper.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, statusId);
        if (orderId != null) {
            return true;
        } else {
            return false;
        }
    }

    //returns true if we have enough products in stock
    //compare ordered product quantity with product stock quantity
    //for each product in this particular order
//        if (orderService.verifyProductCount(order.getId())) {
//            return;
//        }

////    public boolean verifyProductCount(Long id) {
////
////
//
//
//    }

    public Order updateOrderStatusToPending(Long id, int statusId, Order order) {
        order.setStatusId(statusId);
        mapper.updateOrderStatusToPending(order);
        return order;
    }
}

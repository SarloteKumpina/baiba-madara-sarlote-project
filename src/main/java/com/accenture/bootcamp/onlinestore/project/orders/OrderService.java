package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCart;
import org.apache.ibatis.annotations.Select;
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

    //4. if customer is not known, create new order and set order statuss is SHOPPING CART (=4)
    public Order createNewOrder(Order order){
        mapper.createNewOrder(order);
        return order;
    }

    //5. if customer is known, get All orders by cookie (userId)
    public Order getAllOrdersByCookie(Long userId){
        Order order = mapper.getAllOrdersByCookie(userId);
        return order;
    }

    //6. if customer is known, get order by cookie and order statuss is SHOPPING CART (=4)
    public Order getOrderByCookieAndStatusShoppingCart(Long userId){
        Order order = mapper.getOrderByCookieAndStatusShoppingCart(userId);
        return order;
    }

    //7. get order_id of order found in 6th point
    public Long getOrderIdByCookieAndStatusShoppingCart(Long userId){
        Long orderId = mapper.getOrderIdByCookieAndStatusShoppingCart(userId);
        return orderId;
    }



}

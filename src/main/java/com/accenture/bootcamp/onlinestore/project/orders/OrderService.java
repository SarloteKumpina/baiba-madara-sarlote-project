package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCart;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<OrderStatus> findAllStatuses() {
        return mapper.findAllStatuses();
    }

    public List<Order> getAllOrdersProducts(Long id) {
        return mapper.getAllOrdersProducts(id);
    }

    public Order updateOrder(Long id, Order order) {
        Order existing = findOrderById(id);
        existing.setFirstName(order.getFirstName());
        existing.setLastName(order.getLastName());
        existing.setAddress(order.getAddress());
        existing.setPhoneNumber(order.getPhoneNumber());
        existing.setStatusId(order.getStatusId());
        mapper.updateOrder(existing);
        return existing;
    }

    public Order updateOrderStatus(Long id, Order order) {
        Order existing = findOrderById(id);
        existing.setStatusId(order.getStatusId());
        mapper.updateOrderStatus(existing);
        return existing;
    }

    public Order createOrder(Order order) {
        mapper.insertCustomerDetails(order);
        mapper.insertOrderInfo(order);
        mapper.insertOrdersProducts(order);
        return order;
    }

    public Customer createCustomer(Customer customer) {
        return mapper.createCustomer(customer);
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

    public OrderProduct insertIntoOrderProducts(Long productId, int quantity, Long orderId) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProductId(productId);
        orderProduct.setQuantity(quantity);
        orderProduct.setOrderId(orderId);
        mapper.insertIntoOrderProducts (orderProduct);
        return orderProduct;
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

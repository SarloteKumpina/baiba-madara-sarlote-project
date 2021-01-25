package com.accenture.bootcamp.onlinestore.project.checkot;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.customer.CustomerRepository;
import com.accenture.bootcamp.onlinestore.project.orders.Order;
import com.accenture.bootcamp.onlinestore.project.orders.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.accenture.bootcamp.onlinestore.project.orders.OrdersOrderStatus.*;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final OrderService orderService;
    private final CustomerRepository customerRepository;

    public void checkout(CheckoutForm form, String userCookieId) {
        if (userCookieId == null) {
            return;
        }
        Order order = orderService.findOrderByUserIdAndStatusId(userCookieId, ORDER_IN_PROGRESS_STATUS_ID);
        if (order == null) {
            return;
        }
        Customer customer = createCustomer(form);
        customerRepository.insert(customer);
        orderService.updateOrderCustomerId(order.getId(), customer.getId());
        orderService.updateOrderStatusToPending(order.getId(), ORDER_PENDING_FOR_APPROVAL_STATUS_ID, order);
        orderService.minusFromStock(order.getId(), order.getProductId(), order);
    }

    private Customer createCustomer(CheckoutForm form) {
        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setEmail(form.getEmail());
        customer.setPhoneNumber(form.getPhoneNumber());
        customer.setAddress(form.getAddress());
        return customer;
    }
}
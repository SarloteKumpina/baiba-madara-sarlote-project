package com.accenture.bootcamp.onlinestore.project.checkot;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.customer.CustomerService;
import com.accenture.bootcamp.onlinestore.project.orders.Order;
import com.accenture.bootcamp.onlinestore.project.orders.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class CheckoutController {

    final private CustomerService customerService;
    final private OrderService orderService;

    public CheckoutController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId) {
        model.addAttribute("checkoutForm", new CheckoutForm());
        return "shop/checkout/checkout";
    }

    @PostMapping("/checkout")
    public String submitCheckoutForm(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                     Model model,
                                     Order order,
                                     Customer customer){
        customerService.createCustomer(customer);
        order.setUserId(userId);
        Long orderId;
        orderId = orderService.findOrderIdByUserId(order.getUserId());
        order.setId(orderId);
        order.setCustomerId(customer.getId());
//        orderService.updateOrderWithCustomer(orderId, order);
        return "shop/checkout/checkout-success";
    }
}

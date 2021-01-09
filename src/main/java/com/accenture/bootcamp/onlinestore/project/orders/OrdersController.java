package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;

@Controller
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @GetMapping("/admin/orders")
    public String getAllOrders(Model model){
        List<Customer> allOrders = orderService.getAllOrders();
        model.addAttribute("Order", allOrders);
        return "cms/orders/orders-table";
    }

    @GetMapping("/admin/orders/{id}")
    public String findOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("Order", orderService.findOrderById(id));
        return "cms/orders/orders-table";
    }

    @PostMapping("/admin/orders/approve/{id}")
    public String updateStatusToApproved(@PathVariable("orderId") Long id) {
        orderService.updateStatusToApproved(id);
        return "redirect:/admin/orders";
    }


    /*@GetMapping("/admin/orders/cancel/{id}")
    public String cancelOrder(@PathVariable("id") long id) {
        orderService.delete(id);
        return "redirect:/admin/orders";
    }*/


    /*@GetMapping
    public String findProductListByOrderId(Model model) {
        List<OrderProduct> productsForEachOrder = orderRepository.findProductListByOrderId();
        model.addAttribute("productsForEachOrder", productsForEachOrder);
        return "cms/orders/orders-table";
    }

    @GetMapping("/{id}")
    public String findOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("oneOrder", orderService.findOrderById(id));
        return "cms/order/??";
    }

    @GetMapping("/{customer_id}")
    public String findOrderByCustomerId(@PathVariable Long customerId, Model model) {
        model.addAttribute("oneOrder", orderService.findOrderByCustomerId(customerId));
        return "cms/order/??";
    }

    @GetMapping("/{order_time}")
    public String findOrderByTime(@PathVariable Timestamp orderTime, Model model) {
        model.addAttribute("oneOrder", orderService.findOrderByTime(orderTime));
        return "cms/order/??";
    }*/

}

package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.Timestamp;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/orders")
public class OrdersController {

    private final OrderService orderService;

    @GetMapping
    public String getOrderDetails(Model model){
        List<Customer> allOrders = orderService.getOrderDetails();
        model.addAttribute("allOrders", allOrders);
        return "cms/orders/orders-table";
    }

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
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        orderRepository.delete(id);
        return "cms/order/??";
    }*/

}

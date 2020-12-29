package com.accenture.bootcamp.onlinestore.project.orders;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
@AllArgsConstructor
public class OrdersController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @GetMapping(path = {"/admin/orders"})
    public String findAll(Model model){
        List<Order> allOrders = orderRepository.findAll();
        model.addAttribute("allOrders", allOrders);
        return "cms/orders/orders";
    }

    @GetMapping("/admin/orders/{id}")
    public String findOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("oneOrder", orderService.findOrderById(id));
        return "cms/order/??";
    }

    @DeleteMapping("/admin/orders/{id}")
    public String delete(@PathVariable long id) {
        orderRepository.delete(id);
        return "cms/order/??";
    }

}

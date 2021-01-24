package com.accenture.bootcamp.onlinestore.project.orders;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @GetMapping("/admin/orders")
    public String getAllOrders(Model model) {
        List<Order> allOrders = orderService.getAllOrders();
        model.addAttribute("Order", allOrders);
        return "cms/orders/orders-table";
    }

    @GetMapping("/admin/orders/{id}")
    public String findOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("Order", orderService.findOrderById(id));
        return "cms/orders/orders-table";
    }

    @GetMapping("/admin/orders/view-items/{id}")
    public String orderedProducts(@PathVariable Long id, Model model) {
        List<Order> orderedProducts = orderService.orderedProducts(id);
        model.addAttribute("orderedProducts", orderedProducts);
        return "cms/orders/view-items";
    }

    @PostMapping("/admin/orders/update-status/{id}")
    public String updateOrderStatus(@PathVariable("id") Long id, Integer statusId,
                                    Order order, BindingResult result, Model model) {
        if(result.hasErrors()){
            List<Order> statuses = orderService.findAllStatuses();
            model.addAttribute("statuses", statuses);
            return "cms/orders/order-update";
        }
        orderService.updateOrderStatus(id, statusId, order);
        return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/update-status/{id}")
    public String showOrderEditForm(@PathVariable("id") Long id, Model model) {
        Order orderForUpdate = orderService.findOrderById(id);
        List<Order> statuses = orderService.findAllStatuses();
        model.addAttribute("orderForUpdate", orderForUpdate);
        model.addAttribute("statuses", statuses);
        return "cms/orders/order-update";
    }

}

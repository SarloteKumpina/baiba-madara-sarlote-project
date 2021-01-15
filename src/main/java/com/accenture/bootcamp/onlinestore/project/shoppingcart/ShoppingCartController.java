package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.orders.Order;
import com.accenture.bootcamp.onlinestore.project.orders.OrderMapper;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShoppingCartController {

    private final ShoppingCartMapper shoppingCartMapper;
    private final OrderMapper mapper;

    @Autowired
    public ShoppingCartController(ShoppingCartMapper shoppingCartMapper, OrderMapper mapper) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.mapper = mapper;
    }

    //1. get all orders_products
//    @GetMapping(path = {"/cart"})
//    public String ShoppingCart(Model model) {
//        List<Product> products = shoppingCartMapper.findAllOrdersProducts();
//        model.addAttribute("products", products);
//        return "shop/cart";
//    }

    //2. get all products in SHOPPING CART (=4) status
//    @GetMapping(path = {"/cart"})
//    public String ShoppingCart(Model model) {
//        List<Product> products = shoppingCartMapper.getProductsAllOrdersStatusShoppingCart();
//        model.addAttribute("products", products);
//        return "shop/cart";
//    }

    //3. get all products of one order in SHOPPING CART (=4) status
//    if no one product is selected, user sees cart-empty look
//    if at least one product is selected, user sees cart
//    cart look updates after importing or removing products
    @GetMapping(path = {"/cart", "/cart/{orderId}"})
    public String ShoppingCart(@PathVariable(required = false) Long orderId, Model model) {
        if (orderId == null) {
            return "shop/cart-empty";
        } else {
        List<Order> allOrders = mapper.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        Order order = mapper.findOrderById(orderId);
        model.addAttribute("order", order);
        List<Product> products = shoppingCartMapper.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart";
        }
    }


//    @GetMapping("cart/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        cart.delete(id);
//        return "redirect:/cart";
//    }

}

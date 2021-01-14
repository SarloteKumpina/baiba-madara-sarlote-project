package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShoppingCartController {

    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    //1. get all orders_products
//    @GetMapping(path = {"/cart"})
//    public String ShoppingCart(Model model) {
//        List<Product> products = shoppingCartMapper.findAllOrdersProducts();
//        model.addAttribute("products", products);
//        return "shop/cart";
//    }

    //2. get all products in pending (=1) status
    @GetMapping(path = {"/cart"})
    public String ShoppingCart(Model model) {
        List<Product> products = shoppingCartMapper.getProductsPending();
        model.addAttribute("products", products);
        return "shop/cart";
    }

    //3. get all products of one order in pending (=1) status



//    @GetMapping("cart/delete/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        cart.delete(id);
//        return "redirect:/cart";
//    }

}

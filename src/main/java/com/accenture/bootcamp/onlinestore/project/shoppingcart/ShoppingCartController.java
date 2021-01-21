package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping("/cart")
    public String cart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
        if (userId == null){
            return "shop/cart-empty";
        } else {
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart";
        }
    }

    @GetMapping(path = {"/cart/{orderId}"})
    public String ShoppingCart(@PathVariable(required = false) Long orderId, Model model) {
        if (orderId == null) {
            return "shop/cart-empty";
        } else if (orderId != null && shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId).isEmpty()){
            return "shop/cart-empty";
        } else {
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart-by-order";
        }
    }


//URL in cart.html
//<!--<a th:href="@{/cart/delete/{productId}(productId=${product.id})}">-->
    @GetMapping("/cart/delete/{productId}")
    public String removeProductFromShoppingCart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                                @PathVariable(required = true) Long productId) {
        if (userId == null) {
            return "shop/cart-empty";
        } else {
//7. get order_id of order found in 6th point
            Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
//11. remove product from orders_products
            shoppingCartRepository.removeProductFromShoppingCart(productId, orderId);
            return "redirect:/cart";
        }
    }
}

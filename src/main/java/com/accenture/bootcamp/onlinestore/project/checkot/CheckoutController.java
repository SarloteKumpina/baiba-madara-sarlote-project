package com.accenture.bootcamp.onlinestore.project.checkot;

import com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCart;
import com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final ShoppingCartRepository shoppingCartRepository;

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId) {
        model.addAttribute("checkoutForm", new CheckoutForm());
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/checkout/checkout";
    }

    @PostMapping("/checkout")
    public String submitCheckoutForm(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                     Model model,
                                     CheckoutForm checkoutForm){
        checkoutService.checkout(checkoutForm, userId);
        return "shop/checkout/checkout-success";
    }
}

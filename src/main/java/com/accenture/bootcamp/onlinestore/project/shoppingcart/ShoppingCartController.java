package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.addtocart.AddToCartForm;
import com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderProductService orderProductService;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, OrderProductService orderProductService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderProductService = orderProductService;
    }

    @GetMapping("/cart")
    public String getCart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
        if (userId == null){
            return "shop/cart-empty";
        } else {
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
            AddToCartForm productForm = new AddToCartForm();
            List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
            model.addAttribute("products", products);
            model.addAttribute("product", productForm);
        return "shop/cart";
        }
    }

    @PostMapping("/cart/update/{productId}")
    public String updateCart(@PathVariable Long productId,
                             @RequestParam("quantity") int quantity,
                             @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                             Model model) {
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
        if(orderProductService.userHasThisProductInCart(orderId, productId)){
            int productQuantityInCart = orderProductService.getProductQuantityFromOrder(orderId, productId);
            productQuantityInCart = quantity;
            orderProductService.updateProductQuantityInOrder(productQuantityInCart, orderId, productId);
        }
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart";
    }

    @GetMapping(path = {"/cart/{orderId}"})
    public String getShoppingCartsByOrder(@PathVariable(required = false) Long orderId, Model model) {
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

    @GetMapping("/cart/delete/{productId}")
    public String removeProductFromCart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                                @PathVariable(required = true) Long productId) {
        if (userId == null) {
            return "shop/cart-empty";
        } else {
            Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
            shoppingCartRepository.removeProductFromShoppingCart(productId, orderId);
            return "redirect:/cart";
        }
    }
}

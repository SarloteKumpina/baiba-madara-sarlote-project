package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.addtocart.AddToCartForm;
import com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProductService;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;
import static com.accenture.bootcamp.onlinestore.project.orders.OrdersOrderStatus.ORDER_IN_PROGRESS_STATUS_ID;

@Controller
public class ShoppingCartController {

    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderProductService orderProductService;

    @Autowired
    public ShoppingCartController(ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository, OrderProductService orderProductService) {
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderProductService = orderProductService;
    }

    @GetMapping("/cart")
    public String getProductsInShoppingCart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                          Model model) {
        if (userId == null){
            return "shop/cart-empty";
        } else if (userId != null && shoppingCartRepository.getProductsInStatusShoppingCart(ORDER_IN_PROGRESS_STATUS_ID).isEmpty()){
            return "shop/cart-empty-has-cookie";
        } else {
            Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID);
            AddToCartForm productForm = new AddToCartForm();
            List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId, ORDER_IN_PROGRESS_STATUS_ID);
            model.addAttribute("products", products);
            model.addAttribute("product", productForm);
            return "shop/cart";
        }
    }

    @PostMapping("/cart/update/{productId}")
    public String updateProductQuantityInShoppingCart(@PathVariable Long productId,
                             @RequestParam("quantity") int quantity,
                             @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                             AddToCartForm productForm,
                             Model model) {
        Product product = productRepository.findOne(productId);
        Integer productInStock = product.getStock();
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID);
        if(orderProductService.userHasThisProductInCart(orderId, productId)){
            int productQuantityInCart = orderProductService.getProductQuantityFromOrder(orderId, productId);
            productQuantityInCart = quantity;
            if (productForm.getQuantity() == null) {
                model.addAttribute("isError1", true);
            } else if (productForm.getQuantity() > productInStock) {
                model.addAttribute("isError3", true);
                model.addAttribute("productStock", product.getStock());
                model.addAttribute("productName", product.getName());
            } else {
                orderProductService.updateProductQuantityInOrder(productQuantityInCart, orderId, productId);
                model.addAttribute("isSuccess", true);
            }
        }
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId, ORDER_IN_PROGRESS_STATUS_ID);
        model.addAttribute("products", products);
        return "shop/cart";
    }

    @GetMapping(path = {"/cart/{orderId}"})
    public String getProductsInShoppingCartByOrder(@PathVariable(required = false) Long orderId, Model model) {
        if (orderId == null) {
            return "shop/cart-empty";
        } else if (orderId != null && shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId, ORDER_IN_PROGRESS_STATUS_ID).isEmpty()){
            return "shop/cart-empty";
        } else {
            List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId, ORDER_IN_PROGRESS_STATUS_ID);
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
            Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID);
            shoppingCartRepository.removeProductFromShoppingCart(productId, orderId);
            return "redirect:/cart";
        }
    }
}
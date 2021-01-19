package com.accenture.bootcamp.onlinestore.project.addtocart;

import com.accenture.bootcamp.onlinestore.project.orders.OrderService;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import com.accenture.bootcamp.onlinestore.project.orders.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import com.accenture.bootcamp.onlinestore.project.cookies.CookieUtils;
import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
@AllArgsConstructor
public class AddToCartController {

    private final ProductRepository productRepository;
    private final OrderService orderService;

    @GetMapping("/product/{productId}")
    public String productDetails(@PathVariable Long productId,
                                 Model model) {
        Product product = productRepository.findOne(productId);
        AddToCartForm productForm = new AddToCartForm();
        model.addAttribute("product", product);
        model.addAttribute("productForm", productForm);
        return "shop/product-details";
    }

    @PostMapping("/product/{productId}")
    public String addProductToCart(@PathVariable Long productId,
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   AddToCartForm form,
                                   HttpServletResponse response,
                                   Model model) {
        Product product = productRepository.findOne(productId);
        Long orderId;
        if (userId == null){
            userId = UUID.randomUUID().toString();
            addShoppingCartCookieToResponse(response, userId);
            Order order = orderService.createNewOrder(1, userId);
            orderId = orderService.findOrderIdByUserId(order.getUserId());
        } else {
            if (!orderService.userHasOrderWithStatusShoppingCart(userId, 1)) {
                orderService.createNewOrder(1, userId);
            }
            orderId = orderService.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, 1);
        }
        orderService.insertIntoOrderProducts(productId, form.getQuantity(), orderId);
        model.addAttribute("product", product);
        model.addAttribute("productForm", form);
        model.addAttribute("isSuccess", true);
        return "shop/product-details";
    }

    private void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }
}

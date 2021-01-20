package com.accenture.bootcamp.onlinestore.project.addtocart;

import com.accenture.bootcamp.onlinestore.project.cookies.CookieUtils;
import com.accenture.bootcamp.onlinestore.project.orders.Order;
import com.accenture.bootcamp.onlinestore.project.orders.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static com.accenture.bootcamp.onlinestore.project.cookies.Cookies.USER_ID_COOKIE_NAME;
import static com.accenture.bootcamp.onlinestore.project.orders.OrdersOrderStatus.ORDER_IN_PROGRESS_STATUS_ID;

@Service
@AllArgsConstructor
public class AddToCartService {

    private final OrderService orderService;

    public void addProductToCart(Long productId, String userId, AddToCartForm form,
                                 HttpServletResponse response){
        Long orderId;
        if (userId == null){
            userId = UUID.randomUUID().toString();
            addShoppingCartCookieToResponse(response, userId);
            Order order = orderService.createNewOrder(ORDER_IN_PROGRESS_STATUS_ID, userId);
            orderId = orderService.findOrderIdByUserId(order.getUserId());
        } else {
            if (!orderService.userHasOrderWithStatusShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID)) {
                orderService.createNewOrder(ORDER_IN_PROGRESS_STATUS_ID, userId);
            }
            orderId = orderService.findOrderIdByUserIdWhereStatusIsShoppingCart(userId, ORDER_IN_PROGRESS_STATUS_ID);
        }
        orderService.insertIntoOrderProducts(productId, form.getQuantity(), orderId);
    }

    private void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }

}

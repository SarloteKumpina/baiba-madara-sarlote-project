package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.orders.Order;
import com.accenture.bootcamp.onlinestore.project.orders.OrderMapper;
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
    private final OrderMapper mapper;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, OrderMapper mapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.mapper = mapper;
    }

    @GetMapping("/cart")
    public String cart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
        //TODO search products which are associated to order (with status which
        //indicates that order is not completed yet)  made by user with "userId"
        //Then update this order to status which would indicate that user has completed his order
        //and it can't be modified.
//es redzu tikai šo skatu, jo man nav browserī šeit cookie
        if (userId == null){
            return "shop/cart-empty";
        } else {
//vai šeit arī vajag uzsetot cookie? man browserī šajā vietā nav cookie pēc preces pievienošanas grozā
        Long orderId = shoppingCartRepository.getOrderIdByCookieAndStatusShoppingCart(userId);
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart";
        }
    }


    //3. get all orders_products of one order in SHOPPING CART (=1) status
//    if no one product is selected, user sees cart-empty look
//    if at least one product is selected, there is order_id and user sees cart
//    cart look updates after importing or removing products
    @GetMapping(path = {"/cart/{orderId}"})
    public String ShoppingCart(@PathVariable(required = false) Long orderId, Model model) {
        if (orderId == null) {
            return "shop/cart-empty";
        } else if (orderId != null && shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId).isEmpty()){
            return "shop/cart-empty";
        } else {
//        List<Order> allOrders = mapper.getAllOrders();
//        model.addAttribute("allOrders", allOrders);
//        Order order = mapper.findOrderById(orderId);
//        model.addAttribute("order", order);
        List<ShoppingCart> products = shoppingCartRepository.getProductsForOrderStatusShoppingCart(orderId);
        model.addAttribute("products", products);
        return "shop/cart-by-order";
        }
    }


//lai izdzēstu vajag arī orderId norādīt
// nestrādā - saite izveidojas, bet podziņa nestrādā
//    @GetMapping("/cart/{orderId}/delete/{id}")
//    public String removeProductFromShoppingCart(@PathVariable(required = true) Long orderId, Long id) {
//        mapper.findOrderById(orderId);
//        shoppingCartMapper.removeProductFromShoppingCart(id);
//        return "redirect:/cart/{orderId}";
//    }
}

package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.orders.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartRepository implements ShoppingCartMapper {

    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartRepository(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    //6. if customer is known, get order by cookie and order statuss is SHOPPING CART (=1)
    public Order getOrderByCookieAndStatusShoppingCart(String userId){
        Order order = shoppingCartMapper.getOrderByCookieAndStatusShoppingCart(userId);
        return order;
    }

    //7. get order_id of order found in 6th point
    public Long getOrderIdByCookieAndStatusShoppingCart(String userId){
        Long orderId = shoppingCartMapper.getOrderIdByCookieAndStatusShoppingCart(userId);
        return orderId;
    }

    //3. get all orders_products of one order by order_id in SHOPPING CART (=1) status
    @Override
    public List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long id) {
        List<ShoppingCart> products = shoppingCartMapper.getProductsForOrderStatusShoppingCart(id);
        return products;
    }


    //dzēšam produktu no shopping cart and return product in products - pagaidām netaisām
//    @Override
//    public void removeProductFromShoppingCart(Long productId) {
//        shoppingCartMapper.removeProductFromShoppingCart(productId);
//    }
}

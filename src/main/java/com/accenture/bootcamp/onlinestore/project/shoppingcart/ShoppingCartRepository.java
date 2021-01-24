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

    //6. if customer is known, get order by cookie and order statuss is SHOPPING CART (=1) - laikam netiek izmantots
    public Order getOrderByCookieAndStatusShoppingCart(String userId, int statusId){
        Order order = shoppingCartMapper.getOrderByCookieAndStatusShoppingCart(userId, statusId);
        return order;
    }

    //7. get order_id of order found in 6th point - laikam pārnests
    public Long getOrderIdByCookieAndStatusShoppingCart(String userId, int statusId){
        Long orderId = shoppingCartMapper.getOrderIdByCookieAndStatusShoppingCart(userId, statusId);
        return orderId;
    }

    //3. get all orders_products of one order by order_id in SHOPPING CART (=1) status
    @Override
    public List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long id, int statusId) {
        List<ShoppingCart> products = shoppingCartMapper.getProductsForOrderStatusShoppingCart(id, statusId);
        return products;
    }

    //12. get all orders_products in SHOPPING CART (=1) status - OrdersProducts ir
    @Override
    public List<ShoppingCart> getProductsInStatusShoppingCart(int statusId){
        List<ShoppingCart> products = shoppingCartMapper.getProductsInStatusShoppingCart(statusId);
        return products;
    }

    //11. remove product from orders_products
    @Override
    public void removeProductFromShoppingCart(Long productId, Long orderId) {
        shoppingCartMapper.removeProductFromShoppingCart(productId, orderId);
    }
}

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

    public Order getOrderByCookieAndStatusShoppingCart(String userId, int statusId){
        Order order = shoppingCartMapper.getOrderByCookieAndStatusShoppingCart(userId, statusId);
        return order;
    }

    public Long getOrderIdByCookieAndStatusShoppingCart(String userId, int statusId){
        Long orderId = shoppingCartMapper.getOrderIdByCookieAndStatusShoppingCart(userId, statusId);
        return orderId;
    }

    @Override
    public List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long id, int statusId) {
        List<ShoppingCart> products = shoppingCartMapper.getProductsForOrderStatusShoppingCart(id, statusId);
        return products;
    }

    @Override
    public List<ShoppingCart> getProductsInStatusShoppingCart(int statusId){
        List<ShoppingCart> products = shoppingCartMapper.getProductsInStatusShoppingCart(statusId);
        return products;
    }

    @Override
    public void removeProductFromShoppingCart(Long productId, Long orderId) {
        shoppingCartMapper.removeProductFromShoppingCart(productId, orderId);
    }
}

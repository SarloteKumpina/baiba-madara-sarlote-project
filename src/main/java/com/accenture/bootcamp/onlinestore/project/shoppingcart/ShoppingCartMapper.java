package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.orders.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCartTableSql.*;

@Mapper
public interface ShoppingCartMapper {

    @Select(GET_ORDER_DETAILS_BY_USER_ID_AND_STATUS_ID)
    Order getOrderByCookieAndStatusShoppingCart(String userId, int statusId);

    @Select(GET_ORDER_ID_BY_USER_ID_AND_STATUS_ID)
    Long getOrderIdByCookieAndStatusShoppingCart(String userId, int statusId);

    @Select(GET_ORDERS_PRODUCTS_BY_ORDER_ID_AND_STATUS_ID)
    List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long orderId, int statusId);

    @Select(GET_ORDERS_PRODUCTS_BY_STATUS_ID)
    List<ShoppingCart> getProductsInStatusShoppingCart(int statusId);

    @Delete(REMOVE_PRODUCT_FROM_ORDERS_PRODUCTS)
    void removeProductFromShoppingCart(Long productId, Long orderId);
}

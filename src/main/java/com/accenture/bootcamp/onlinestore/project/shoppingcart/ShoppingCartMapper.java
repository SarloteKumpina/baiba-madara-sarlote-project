package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.orders.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.accenture.bootcamp.onlinestore.project.shoppingcart.ShoppingCartTableSql.*;

@Mapper
public interface ShoppingCartMapper {

//    6. if customer is known, get order by cookie and order statuss is SHOPPING CART (=1) - Orders nav
    @Select(GET_ORDER_DETAILS_BY_USER_ID_AND_STATUS_ID)
    Order getOrderByCookieAndStatusShoppingCart(String userId, int statusId);

//    7. get order_id of order found in 6th point - Orders ir
    @Select(GET_ORDER_ID_BY_USER_ID_AND_STATUS_ID)
    Long getOrderIdByCookieAndStatusShoppingCart(String userId, int statusId);

//    3. get all orders_products of one order in SHOPPING CART (=1) status - OrdersProducts ir
    @Select(GET_ORDERS_PRODUCTS_BY_ORDER_ID_AND_STATUS_ID)
    List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long orderId, int statusId);

//    12. get all orders_products in SHOPPING CART (=1) status - OrdersProducts ir
    @Select(GET_ORDERS_PRODUCTS_BY_STATUS_ID)
    List<ShoppingCart> getProductsInStatusShoppingCart(int statusId);

//    11. remove product from orders_products - OrdersProducts ir
    @Delete(REMOVE_PRODUCT_FROM_ORDERS_PRODUCTS)
    void removeProductFromShoppingCart(Long productId, Long orderId);
}

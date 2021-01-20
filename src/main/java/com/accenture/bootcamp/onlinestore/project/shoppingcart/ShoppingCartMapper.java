package com.accenture.bootcamp.onlinestore.project.shoppingcart;

import com.accenture.bootcamp.onlinestore.project.orders.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    //6. if customer is known, get order by cookie and order statuss is SHOPPING CART (=1)
    @Select("select * from orders where user_id = #{id} and status_id = 1")
    Order getOrderByCookieAndStatusShoppingCart(String userId);

    //7. get order_id of order found in 6th point
    @Select("select id from orders where user_id = #{id} and status_id = 1")
    Long getOrderIdByCookieAndStatusShoppingCart(String userId);

    //3. get all orders_products of one order in SHOPPING CART (=1) status
    @Select("select products.imageUri, products.id, products.name, products.price, orders_products.quantity, " +
            "(products.price * orders_products.quantity) as total\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id\n" +
            "inner join status on orders.status_id = status.id\n" +
            "where status.id = '1' AND #{id} IS NULL OR (orders.id = #{id})")
    List<ShoppingCart> getProductsForOrderStatusShoppingCart(Long orderId);

    //11. remove product from orders_products
    @Delete("delete from orders_products where product_id=#{productId} AND order_id = #{orderId}")
    void removeProductFromShoppingCart(Long productId, Long orderId);
}

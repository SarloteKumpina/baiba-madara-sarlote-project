package com.accenture.bootcamp.onlinestore.project.orderproduct;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProductTableSql.*;

@Mapper
public interface OrderProductMapper {

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_INTO_ORDERS_PRODUCTS)
    void insertIntoOrderProducts(OrderProduct orderProduct);

    @Select(FIND_ORDER_PRODUCT_ID_BY_ORDER_ID_AND_PRODUCT_ID)
    Long findOrderProductIdByOrderIdAndProductId(Long orderId, Long productId);

    @Select(GET_PRODUCT_QUANTITY_FROM_ORDER)
    int getProductQuantityFromOrder(Long orderId, Long productId);

    @Update(UPDATE_PRODUCT_QUANTITY_IN_ORDER)
    void updateProductQuantityInOrder(int quantity, Long orderId, Long productId);

    @Select(GET_PRODUCTS_PER_ORDER_IN_STATUS_SHOPPING_CART)
    List<Product> getProductsForOrderInStatusShoppingCart(Long orderId, int statusId);

    @Delete(REMOVE_PRODUCT_FROM_SHOPPING_CART)
    void removeProductFromShoppingCart(Long productId, Long orderId);
}

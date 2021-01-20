package com.accenture.bootcamp.onlinestore.project.orderproduct;

import org.apache.ibatis.annotations.*;

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
}

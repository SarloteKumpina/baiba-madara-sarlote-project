package com.accenture.bootcamp.onlinestore.project.orders;

import org.apache.ibatis.annotations.*;
import java.util.List;

import static com.accenture.bootcamp.onlinestore.project.orders.OrderTableSql.*;

@Mapper
public interface OrderMapper {

    @Select(SELECT_FROM_ORDER_GROUP_BY_ID)
    List<Order> getAllOrders();

    @Select(SELECT_FROM_ORDER_BY_ID_QUERY)
    Order findOrderById(Long id);

    @Select(SELECT_ORDER_PRODUCTS)
    List<Order> orderedProducts(Long id);

    @Select(SELECT_FROM_STATUS)
    List<Order> findAllStatuses();

    @Update(UPDATE_ORDER_STATUS)
    void updateOrderStatus(Order order);

    @Update(UPDATE_ORDER_WITH_CUSTOMER_ID)
    void updateOrderCustomerId(Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_INTO_ORDERS)
    void createOrder(Order order);

    @Select(SELECT_ORDER_BY_USER_ID)
    Long findOrderIdByUserId(String userId);

    @Select(FIND_ORDER_BY_USER_ID_AND_STATUS_ID)
    Order findOrderByUserIdAndStatusId(String userId, int statusId);

    @Select(FIND_ORDER_BY_USER_ID_AND_STATUS_ID)
    Long findOrderIdByUserIdWhereStatusIsShoppingCart(String userId, int statusId);

    @Update(UPDATE_ORDER_STATUS)
    void updateOrderStatusToPending(Order order);

}

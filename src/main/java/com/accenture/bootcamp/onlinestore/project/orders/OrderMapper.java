package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.orderproduct.OrderProduct;
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
    List<Order> getAllOrdersProducts(Long id);

    @Select(SELECT_FROM_STATUS)
    List<Order> findAllStatuses();

    @Update(UPDATE_ORDER_STATUS)
    void updateOrderStatus(Order order);

    @Update(UPDATE_ORDER_INFORMATION)
    void updateOrder(Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_CUSTOMER_DETAILS)
    void insertCustomerDetails(Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(CREATE_CUSTOMER)
    Customer createCustomer(Customer customer);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_INTO_ORDERS)
    void createOrder(Order order);

    @Select(SELECT_ORDER_BY_USER_ID)
    Long findOrderIdByUserId(String userId);

    @Select(FIND_ORDER_BY_USER_ID_WHERE_STATUS_IS_SHOPPING_CART)
    Long findOrderIdByUserIdWhereStatusIsShoppingCart(String userId, int statusId);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_INTO_ORDERS_PRODUCTS)
    void insertIntoOrderProducts(OrderProduct orderProduct);

}

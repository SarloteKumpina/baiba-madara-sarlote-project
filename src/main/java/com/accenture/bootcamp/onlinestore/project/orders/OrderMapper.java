package com.accenture.bootcamp.onlinestore.project.orders;

import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper {

    @Select("select o.id, o.order_time, SUM(products.price * op.quantity) as orderTotalSum,\n" +
            " s.name as statusName, c.id, c.first_name,\n" +
            " c.last_name, c.address, c.phone_number \n" +
            " from orders as o\n" +
            " left join orders_products as op on op.order_id = o.id\n" +
            " left join products on products.id = op.product_id\n" +
            " left join customers as c on c.id=o.customer_id\n" +
            " left join status as s on o.status_id=s.id\n" +
            " group by o.id;")
    List<Order> getAllOrders();

    @Select("select o.id, o.order_time, SUM(products.price * op.quantity) as orderTotalSum,\n" +
            " s.name as statusName, c.id, c.first_name, c.last_name, c.address, c.phone_number \n" +
            " from orders as o\n" +
            " left join orders_products as op on op.order_id = o.id\n" +
            " left join products on products.id = op.product_id\n" +
            " left join customers as c on c.id=o.customer_id\n" +
            " left join status as s on o.status_id=s.id \n" +
            " where o.id = #{id}")
    Order findOrderById(Long id);

    @Select("select s.id as statusId, s.name\n" +
            "from status as s;")
    List<OrderStatus> findAllStatuses();

    @Update("UPDATE orders SET status_id = #{statusId} where id = #{id}")
    void updateOrderStatus (Order order);

     @Update("UPDATE orders SET first_name = #{firstName}, last_name #{lastName}," +
                " address #{address}, phone_number #{phoneNumber}," +
                " status_id = #{statusId} where id = #{id}")
        void updateOrder (Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into customers(id, first_name, last_name, address, phone_number)" +
            " values(#{id}, #{firstName}, #{lastName}, #{address}, #{phoneNumber})")
    void insertCustomerDetails(Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into orders(user_id, customer_id)" +
            " values(#{userId}, #{customerId})")
    void insertOrderInfo(Order order);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into orders_products (product_id, order_id, quantity)" +
            " values( #{productId},#{orderId}, #{quantity}")
    void insertOrdersProducts(Order order);

}

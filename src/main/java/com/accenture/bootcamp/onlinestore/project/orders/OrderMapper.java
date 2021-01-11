package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;

import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper {

    @Select("select o.id, o.order_time, s.id as statusId, s.name as statusName, c.first_name, c.last_name, c.address, c.phone_number \n" +
            "from\n" +
            "customers as c\n" +
            "inner join \n" +
            "orders as o\n" +
            "on c.id=o.customer_id\n" +
            "inner join \n" +
            "status as s\n" +
            "on o.status_id=s.id;")
    List<Customer> getAllOrders();

    @Select("select o.id, o.order_time, s.id as statusId, s.name as statusName, c.id, c.first_name, c.last_name, c.address, c.phone_number from\n" +
            "customers as c\n" +
            "inner join orders as o\n" +
            "on c.id=o.customer_id\n" +
            "inner join status as s\n" +
            "on o.status_id=s.id where o.id = #{id}")
    Customer findOrderById(Long id);

    @Select("select s.id as statusId, s.name\n" +
            "from status as s;")
    List<OrderStatus> findAllStatuses();

    @Update("UPDATE orders SET status_id as statusId = #{status_id} where id = #{id}")
    void update (Order order);

}

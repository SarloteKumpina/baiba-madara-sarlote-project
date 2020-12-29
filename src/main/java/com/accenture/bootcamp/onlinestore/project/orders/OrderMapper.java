package com.accenture.bootcamp.onlinestore.project.orders;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface OrderMapper {

    @Select("select id, customer_id, order_time from orders where id = #{id}")
    Order findOrderById(long id);

    @Select("select id, customer_id, order_time from orders")
    List<Order> findAll();

    @Delete("delete from orders where id=#{id}")
    void delete(Order order);

}

package com.accenture.bootcamp.onlinestore.project.orders;

import com.accenture.bootcamp.onlinestore.project.customer.Customer;
import com.accenture.bootcamp.onlinestore.project.orders.op.OrderProduct;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface OrderMapper {

    @Select("select o.id, o.order_time, c.id, c.first_name, c.last_name, c.address, c.phone_number from\n" +
            " customers as c\n" +
            " inner join orders as o\n" +
            " on c.id=o.customer_id;")
    List<Customer> getOrderDetails();


   /* @Select("select id, customer_id, order_time from orders where id = #{id}")
    Order findOrderById(long id);

    @Select("select id, customer_id, order_time from orders where customer_id = #{customer_id}")
    Order findOrderByCustomerId(long customerId);

    @Select("select id, customer_id, order_time from orders where order_time = #{order_time}")
    Order findOrderByTime(Timestamp orderTime);

    @Delete("delete from orders where id=#{id}")
    void delete(Order order);*/

    //select products.id, products.imageUri, products.name,
    // orders_products.quantity, products.price
    //from products
    //inner join orders_products
    //on products.id=orders_products.product_id
    //where orders_products.order_id = 1;

    //just an idea, still working on it
    //@Select("SELECT * FROM products "
    //         + "INNER JOIN orders_products  "
    //        + "ON (products.id=orders_products.product_id) "
    //        + "WHERE (orders_products.order_id LIKE %:order_id%) ")
    //List<OrderProduct> findProductListByOrderId();
}

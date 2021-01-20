package com.accenture.bootcamp.onlinestore.project.orderproduct;

public final class OrderProductTableSql {

    public static final String INSERT_INTO_ORDERS_PRODUCTS = "insert into orders_products(id, product_id, quantity, order_id)" +
            " values(#{id}, #{productId}, #{quantity}, #{orderId})";

    public static final String FIND_ORDER_PRODUCT_ID_BY_ORDER_ID_AND_PRODUCT_ID = "select id from orders_products " +
            "where order_id=#{orderId} and product_id=#{productId}";

    public static final String GET_PRODUCT_QUANTITY_FROM_ORDER = "select quantity from orders_products where " +
            "order_id=#{orderId} and product_id=#{productId}";

    public static final String UPDATE_PRODUCT_QUANTITY_IN_ORDER = "update orders_products set quantity=#{quantity} " +
            "where order_id=#{orderId} and product_id=#{productId}";

}

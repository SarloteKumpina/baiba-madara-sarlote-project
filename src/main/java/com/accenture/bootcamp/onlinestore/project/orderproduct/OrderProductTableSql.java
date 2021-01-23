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

    public static final String GET_PRODUCTS_PER_ORDER_IN_STATUS_SHOPPING_CART =
            "select products.imageUri, products.id, " +
            "products.name, products.price, orders_products.quantity, " +
            "(products.price * orders_products.quantity) as total\n" +
            "from orders_products\n" +
            "inner join orders on orders_products.order_id = orders.id\n" +
            "inner join products on orders_products.product_id = products.id\n" +
            "inner join status on orders.status_id = status.id\n" +
            "where status.id=#{statusId} AND #{id} IS NULL OR (orders.id = #{id})";

    public static final String REMOVE_PRODUCT_FROM_SHOPPING_CART = "delete from orders_products " +
            "where product_id=#{productId} AND order_id = #{orderId}";
}

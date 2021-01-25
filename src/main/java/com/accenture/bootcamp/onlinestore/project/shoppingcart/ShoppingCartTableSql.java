package com.accenture.bootcamp.onlinestore.project.shoppingcart;

public final class ShoppingCartTableSql {

    public static final String GET_ORDER_DETAILS_BY_USER_ID_AND_STATUS_ID =
        "select * from orders where user_id = #{userId} and status_id = #{statusId}";

    public static final String GET_ORDER_ID_BY_USER_ID_AND_STATUS_ID =
        "select id from orders where user_id = #{userId} and status_id = #{statusId}";

    public static final String GET_ORDERS_PRODUCTS_BY_ORDER_ID_AND_STATUS_ID =
        "select products.imageUri, products.id, products.name, products.price, orders_products.quantity, " +
        "(products.price * orders_products.quantity) as total\n" +
        "from orders_products\n" +
        "inner join orders on orders_products.order_id = orders.id\n" +
        "inner join products on orders_products.product_id = products.id\n" +
        "inner join status on orders.status_id = status.id\n" +
        "where status.id = #{statusId} AND #{orderId} IS NULL OR (orders.id = #{orderId})";

    public static final String GET_ORDERS_PRODUCTS_BY_STATUS_ID =
        "select products.imageUri, products.id, " +
        "products.name, products.price, orders_products.quantity, " +
        "(products.price * orders_products.quantity) as total\n" +
        "from orders_products\n" +
        "inner join orders on orders_products.order_id = orders.id\n" +
        "inner join products on orders_products.product_id = products.id\n" +
        "inner join status on orders.status_id = status.id\n" +
        "where status.id=#{statusId}";

    public static final String REMOVE_PRODUCT_FROM_ORDERS_PRODUCTS = "delete from orders_products " +
        "where product_id=#{productId} AND order_id = #{orderId}";
}

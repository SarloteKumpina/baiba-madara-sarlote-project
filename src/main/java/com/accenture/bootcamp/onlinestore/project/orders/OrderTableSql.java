package com.accenture.bootcamp.onlinestore.project.orders;

public final class OrderTableSql {

    public static final String SELECT_FROM_ORDER = "select o.id, o.order_time, SUM(products.price * op.quantity) as orderTotalSum,\n" +
            " s.name as statusName, c.id, c.first_name,\n" +
            " c.last_name, c.address, c.phone_number \n" +
            " from orders as o\n" +
            " left join orders_products as op on op.order_id = o.id\n" +
            " left join products on products.id = op.product_id\n" +
            " left join customers as c on c.id=o.customer_id\n" +
            " left join status as s on o.status_id=s.id";

    public static final String SELECT_FROM_ORDER_GROUP_BY_ID = SELECT_FROM_ORDER + " group by o.id;";
    public static final String SELECT_FROM_ORDER_BY_ID_QUERY = SELECT_FROM_ORDER + " where o.id = #{id};";
    public static final String SELECT_ORDER_PRODUCTS = "select op.order_id, p.id as productId, p.imageUri, p.name as productName,\n" +
            " SUM(p.price * op.quantity) as orderTotalSum, op.quantity, o.id, c.first_name, c.last_name\n" +
            "from products as p\n" +
            "inner join orders_products as op on p.id=op.product_id\n" +
            "left join orders as o on op.order_id=o.id\n" +
            "left join customers as c on o.customer_id=c.id\n" +
            "where op.order_id = #{order_id} group by op.id";

    public static final String SELECT_FROM_STATUS = "select s.id as statusId, s.name as statusName\n" +
            "from status as s;";
    public static final String UPDATE_ORDER_STATUS = "UPDATE orders SET status_id = #{statusId} where id = #{id}";
    public static final String UPDATE_ORDER_WITH_CUSTOMER_ID = "update orders set customer_id = #{id} where id = #{id};";

    public static final String CREATE_CUSTOMER = "insert into customers(first_name, last_name, phone_number, email, address)" +
            " values(#{firstName}, #{lastName}, #{phoneNumber}, #{email}, #{address})";

    public static final String INSERT_INTO_ORDERS = "insert into orders(id, customer_id, order_time, status_id, user_id)\n" +
            " values(#{id}, #{customerId},#{orderTime}, #{statusId}, #{userId})";

    public static final String SELECT_ORDER_BY_USER_ID = "select id from orders where user_id=#{userId}";

    public static final String FIND_ORDER_BY_USER_ID_WHERE_STATUS_IS_SHOPPING_CART = "select id from orders " +
            "where user_id=#{userId} and status_id=#{statusId}";

    public static final String INSERT_INTO_ORDERS_PRODUCTS = "insert into orders_products(id, product_id, quantity, order_id)" +
            " values(#{id}, #{productId}, #{quantity}, #{orderId})";

}

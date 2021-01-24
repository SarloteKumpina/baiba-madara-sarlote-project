package com.accenture.bootcamp.onlinestore.project.products;

public final class ProductTableSql {

public static final String FIND_ONE = "select id, name, price, description, stock, imageUri from products where id = #{id}";

    public static final String FIND_ALL = "select id, name, price, description, stock, imageUri from products";

    public static final String FIND_ALL_NAMES = "select name from products";

    public static final String FIND_SELECTED_CATEGORY_ID = "SELECT * FROM categories WHERE id IN (#{id})";

    public static final String GET_PRODUCTS_FOR_CATEGORY = "select products.id, products.name, products.price, products.description, " +
            "products.stock, products.imageUri " +
            "from products " +
            "inner join products_categories " +
            "on products_categories.product_id = products.id " +
            "where #{category_id} IS NULL OR (products_categories.category_id = #{category_id})";

    public static final String UPDATE = "UPDATE products SET name = #{name}, price = #{price}, " +
            "description = #{description}, stock = #{stock}, imageUri = #{imageUri} " +
            "WHERE id = #{id}";

    public static final String INSERT_PRODUCT = "insert into products(name, price, description, stock, imageUri) " +
            "values(#{name},#{price},#{description},#{stock},#{imageUri})";

    public static final String INSERT_PRODUCT_CATEGORY = "insert into products_categories(product_id, category_id) " +
            "values(#{productId},#{categoryId})";

    public static final String DELETE = "delete from products where id=#{productId}";

    public static final String DELETE_PRODUCT_CATEGORIES = "delete from products_categories where product_id=#{productId}";

}

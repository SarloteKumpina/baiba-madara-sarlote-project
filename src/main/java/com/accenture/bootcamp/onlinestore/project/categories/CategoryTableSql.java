package com.accenture.bootcamp.onlinestore.project.categories;

import org.apache.ibatis.annotations.*;

import java.util.List;

public final class CategoryTableSql {

    public static final String FIND_ONE = "select id, name, imageUri from categories where id = #{id}";

    public static final String FIND_BY_NAME = "select name from categories where name = #{name}";

    public static final String FIND_ALL = "select id, name, imageUri from categories";

    public static final String FIND_ALL_NAMES = "select name from categories";

    public static final String GET_CATEGORIES_FOR_PRODUCT = "select categories.id, categories.name, " +
            "categories.imageUri from categories inner join products_categories " +
            "on products_categories.category_id = categories.id " +
            "where products_categories.product_id = #{productId}";

    public static final String GET_CATEGORY_IDS_FOR_PRODUCT = "select categories.id from categories " +
            "inner join products_categories on products_categories.category_id = categories.id " +
            "where products_categories.product_id = #{productId}";

    public static final String CREATE = "insert into categories(id, name, imageUri) " +
            "values(#{id}, #{name},#{imageUri})";

    public static final String UPDATE = "update categories set name = #{name}, " +
            "imageUri=#{imageUri} where id=#{id}";

    public static final String DELETE = "delete from categories where id=#{id}";

    public static final String FIND_HOW_MANY_TIMES_CATEGORY_NAME_APPEARS = "select count(*) " +
            "from categories where name=#{name}";

}

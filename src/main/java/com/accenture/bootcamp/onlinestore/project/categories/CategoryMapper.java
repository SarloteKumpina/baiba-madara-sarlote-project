package com.accenture.bootcamp.onlinestore.project.categories;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select id, name, imageUri from categories where id = #{id}")
    Category findOne(long id);

    @Select("select id, name, imageUri from categories")
    List<Category> findAll();

    @Select("select categories.id, categories.name, categories.imageUri\n" +
            "from categories\n" +
            "inner join products_categories\n" +
            "on products_categories.category_id = categories.id\n" +
            "where products_categories.product_id = #{productId}")
    List<Category> getCategoriesForProduct(long productId);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into categories(id, name, imageUri)" +
            " values(#{id}, #{name},#{imageUri})")
    void create(Category category);

    @Update("update categories set name = #{name}, imageUri=#{imageUri} where id=#{id}")
    void update(Category category);

    @Delete("delete from categories where id=#{id}")
    void delete(Category category);

}

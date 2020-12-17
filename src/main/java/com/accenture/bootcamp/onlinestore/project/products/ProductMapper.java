package com.accenture.bootcamp.onlinestore.project.products;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select id, name, category_id, price, description, stock from products where id = #{id}")
    Product findOne(long id);

    @Select("select id, name, category_id, price, description, stock from products")
    List<Product> findAll();

    @Update("update products set stock=#{stock} where id=#{id}")
    void update(Product product);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products(name, price, category_id, description, stock, imageUri)" +
            " values(#{name},#{price},#{category_id},#{description},#{stock},#{imageUri})")
    void insert(Product product);

    @Delete("delete from products where id=#{id}")
    void delete(Product product);

}

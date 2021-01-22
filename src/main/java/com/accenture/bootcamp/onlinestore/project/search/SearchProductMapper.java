package com.accenture.bootcamp.onlinestore.project.search;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchProductMapper {

    @Select("SELECT * FROM products WHERE name LIKE concat(\"%\",concat(upper(#{name}),\"%\"))")
    List<Product> findByNameContains(String name);
}

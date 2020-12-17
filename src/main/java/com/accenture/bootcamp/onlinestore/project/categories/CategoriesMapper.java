package com.accenture.bootcamp.onlinestore.project.categories;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoriesMapper {

    @Select("select id, name, imageUri from categories where id = #{id}")
    Categories findOne(long id);

    @Select("select id, name, imageUri from categories")
    List<Categories> findAll();

    @Update("update categories set imageUri=#{imageUri} where id=#{id}")
    void update(Categories categorie);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into categories(name, imageUri)" +
            " values(#{name},#{imageUri})")
    void insert(Categories categorie);

    @Delete("delete from categories where id=#{id}")
    void delete(Categories categorie);

}

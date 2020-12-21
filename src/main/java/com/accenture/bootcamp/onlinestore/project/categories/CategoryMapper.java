package com.accenture.bootcamp.onlinestore.project.categories;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select id, name, imageUri from categories where id = #{id}")
    Category findOne(long id);

    @Select("select id, name, imageUri from categories")
    List<Category> findAll();

//    @Select("select * from categories where id in (#{id}, #{id})")
//    List<Categories> findAllSelected(List<Categories> categories);

    @Update("update categories set name = #{name}, imageUri=#{imageUri} where id=#{id}")
    void update(Category categories);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into categories(name, imageUri)" +
            " values(#{name},#{imageUri})")
    void insert(Category categories);

    @Delete("delete from categories where id=#{id}")
    void delete(Category categories);

}

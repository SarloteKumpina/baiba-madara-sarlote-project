package com.accenture.bootcamp.onlinestore.project.categories;

import org.apache.ibatis.annotations.*;

import static com.accenture.bootcamp.onlinestore.project.categories.CategoryTableSql.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select(FIND_ONE)
    Category findOne(Long id);

    @Select(FIND_BY_NAME)
    String findByName(String name);

    @Select(FIND_ALL)
    List<Category> findAll();

    @Select(FIND_ALL_NAMES)
    List<String> findAllNames();

    @Select(GET_CATEGORIES_FOR_PRODUCT)
    List<Category> getCategoriesForProduct(Long productId);

    @Select(GET_CATEGORY_IDS_FOR_PRODUCT)
    List<Long> getCategoryIdsForProduct(Long productId);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(CREATE)
    void create(Category category);

    @Update(UPDATE)
    void update(Category category);

    @Delete(DELETE)
    void delete(Category category);

    @Select(FIND_HOW_MANY_TIMES_CATEGORY_NAME_APPEARS)
    int findHowManyTimesCategoryNameAppears(String name);

}

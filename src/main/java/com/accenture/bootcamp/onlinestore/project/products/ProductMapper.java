package com.accenture.bootcamp.onlinestore.project.products;

import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.accenture.bootcamp.onlinestore.project.products.ProductTableSql.*;

@Mapper
public interface ProductMapper {

    @Select(FIND_ONE)
    Product findOne(Long id);

    @Select(FIND_ALL)
    List<Product> findAll();

    @Select(FIND_ALL_NAMES)
    List<String> findAllNames();

    @Select(FIND_SELECTED_CATEGORY_ID)
    Long findSelectedCategoryId(long categoryId);

    @Select(GET_PRODUCTS_FOR_CATEGORY)
    List<Product> getProductsForCategory(Long categoryId);

    @Update(UPDATE)
    void update(Product product);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert(INSERT_PRODUCT)
    void insertProduct(Product product);

    @Insert(INSERT_PRODUCT_CATEGORY)
    void insertProductCategory(Long productId, Long categoryId);

    @Delete(DELETE)
    void delete(Long productId);

    @Delete(DELETE_PRODUCT_CATEGORIES)
    void deleteProductCategories(Long productId);
}

package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select id, name, price, description, stock from products where id = #{id}")
    Product findOne(long id);

    @Select("select id, name, price, description, stock, imageUri from products")
    List<Product> findAll();

    @Select("SELECT * FROM categories WHERE id IN (#{id})")
    long findSelectedCategoryId(long categoryId);

    @Select("select products.id, products.name, products.price, products.description," +
            "products.stock, product.imageUri\n" +
            "from products\n" +
            "inner join products_categories\n" +
            "on products_categories.product_id = products.id\n" +
            "where products_categories.categoryId = #{categoryId}")
    List<Product> getProductsForCategory(long categoryId);

    @Update("UPDATE products SET name = #{name}, price = #{price}," +
            "description = #{description}, stock = #{stock}, imageUri = #{imageURI}" +
            " WHERE id = #{id}")
    void update(Product product);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products(name, price, description, stock, imageUri)" +
            " values(#{name},#{price},#{description},#{stock},#{imageUri})")
    void insertProduct(Product product);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products_categories(product_id, category_id)" +
            " values(#{product_id},#{category_id})")
    void insertProductCategory(long productId, long categoryId);



//    @Options(useGeneratedKeys = true,
//            keyProperty = "id",
//            keyColumn = "id")
//    @Insert("insert into products_categories(product_id, category_id)" +
//            " values(#{product_id},#{category_id})")
//    void insertProductCategory(long productId, List<Long> categoryIds);


    @Delete("delete from products where id=#{product_id}")
    void delete(long productId);

    @Delete("delete from products_categories where product_id=#{product_id}")
    void deleteProductCategories(long productId);
}

package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import java.util.List;

public interface CategoryRepository {
    Category findOne(long id);

    List<Category> findAll();

//    List<Product> getProductsForCategory(long productd);

//    Category insert(CategoryRequest category);

    Category create(Category category);

//    Category update(long id, CategoryRequest category);

    Category update(long id, Category category);

    void delete(long id);
}
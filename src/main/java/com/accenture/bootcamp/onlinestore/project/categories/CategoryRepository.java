package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;

import java.util.List;

public interface CategoryRepository {
    Category findOne(Long id);

    List<Category> findAll();

    List<Product> getProductsForCategory(Long productId);

//    Category insert(CategoryRequest category);

    Category create(Category category);

//    Category update(Long id, CategoryRequest category);

    Category update(Long id, Category category);

    void delete(Long id);
}
package com.accenture.bootcamp.onlinestore.project.categories;

import java.util.List;

public interface CategoryRepository {
    Category findOne(Long id);

    String findByName(String name);

    List<Category> findAll();

    List<Long> getCategoryIdsForProduct(Long productId);

    List<String> findAllNames();

    Category create(Category category);

    Category update(Long id, Category category);

    void delete(Long id);
}
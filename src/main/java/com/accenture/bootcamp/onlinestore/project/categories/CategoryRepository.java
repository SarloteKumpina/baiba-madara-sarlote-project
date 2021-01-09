package com.accenture.bootcamp.onlinestore.project.categories;

import java.util.List;

public interface CategoryRepository {
    Category findOne(Long id);

    List<Category> findAll();

    Category create(Category category);

    Category update(Long id, Category category);

    void delete(Long id);
}
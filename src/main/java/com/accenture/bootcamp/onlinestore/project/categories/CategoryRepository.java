package com.accenture.bootcamp.onlinestore.project.categories;

import java.util.List;

public interface CategoryRepository {
    Category findOne(long id);

    List<Category> findAll();

    Category insert(CategoryRequest categorie);

    Category update(long id, CategoryRequest categorie);

    void delete(long id);
}
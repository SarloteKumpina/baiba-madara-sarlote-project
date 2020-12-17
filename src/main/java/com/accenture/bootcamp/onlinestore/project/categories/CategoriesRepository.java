package com.accenture.bootcamp.onlinestore.project.categories;

import java.util.List;

public interface CategoriesRepository {
    Categories findOne(long id);

    List<Categories> findAll();

    Categories insert(CategorieRequest categorie);

    Categories update(long id, CategorieRequest categorie);

    void delete(long id);
}
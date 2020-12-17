package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Products findOne(long id);

    List<Products> findAll();

    Products insert(ProductRequest product);

    Products update(long id, ProductRequest product);

    void delete(long id);
}

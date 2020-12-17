package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Product findOne(long id);

    List<Product> findAll();

    Product insert(ProductRequest product);

    Product update(long id, ProductRequest product);

    void delete(long id);
}

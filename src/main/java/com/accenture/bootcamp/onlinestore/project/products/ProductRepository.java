package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Product findOne(long id);

    List<Product> findAll();

    Product insertProduct(ProductRequest product);

    Product insertProductCategory(List<Long> categoryIds);

    Product update(long id, ProductRequest product);

    void delete(long id);
}

package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Product findOne(Long id);

    List<Product> findAll();

    Product insertProduct(Product product);

//    void insertProductCategory(long productId, List<Long> categoryIds);

    Product update(Product product);

    void delete(Long id);
}

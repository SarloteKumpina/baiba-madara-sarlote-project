package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Product findOne(Long id);

    List<Product> findAll();

    List<Product> getProductsForCategory(Long productId);

    Product insertProduct(Product product);

//    void insertProductCategory(Long productId, List<Long> categoryIds);

    Product update(Product product);

    void delete(Long id);
}

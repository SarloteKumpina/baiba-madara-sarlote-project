package com.accenture.bootcamp.onlinestore.project.products;

import java.util.List;

public interface ProductRepository {
    Product findOne(Long id);

    List<Product> findAll();

    List<String> findAllNames();

    List<Product> getProductsForCategory(Long categoryId);

    Product insertProduct(Product product);

    Product update(Product product);

    void delete(Long id);
}

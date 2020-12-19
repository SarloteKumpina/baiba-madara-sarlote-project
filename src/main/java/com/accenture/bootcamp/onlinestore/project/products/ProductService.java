package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService implements ProductRepository {

    private final ProductMapper mapper;

    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Product findOne(long id) {
        Product product = mapper.findOne(id);
        if (product == null) {
            throw new NotFoundException("Product with id " + id + " doesn't exist");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        return mapper.findAll();
    }

    @Override
    public Product insertProduct(ProductRequest request) {
        Product product = new Product(request);
        mapper.insertProduct(product);
        return product;
    }

//    @Override
//    public Product insertProductCategory(List<Long> categoryIds) {
//        return null;
//    }

    @Override
    public Product update(long id, ProductRequest product) {
        Product existing = findOne(id);
        existing.setName(product.getName());
        existing.setCategoryIds(product.getCategoryIds());
        existing.setPrice(product.getPrice());
        existing.setDescription(product.getDescription());
        existing.setStock(product.getStock());
        existing.setImageUri(product.getImageUri());
        mapper.update(existing);
        return existing;
    }

    @Override
    public void delete(long id) {
        mapper.delete(findOne(id));
    }
}

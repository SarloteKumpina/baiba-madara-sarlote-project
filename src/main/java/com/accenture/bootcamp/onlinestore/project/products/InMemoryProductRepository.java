package com.accenture.bootcamp.onlinestore.project.products;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InMemoryProductRepository implements ProductRepository {

    private final ProductMapper mapper;

    public InMemoryProductRepository(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Products findOne(long id) {
        return mapper.findOne(id);
    }

    @Override
    public List<Products> findAll() {
        return mapper.findAll();
    }

    @Override
    public Products insert(ProductRequest request) {
        Products product = new Products(request);
        mapper.insert(product);
        return product;
    }

    @Override
    public Products update(long id, ProductRequest product) {
        Products existing = findOne(id);
        existing.setName(product.getName());
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

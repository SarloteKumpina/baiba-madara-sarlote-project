package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryMapper;
import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService implements ProductRepository {

    private final ProductMapper mapper;
    private final CategoryMapper categoryMapper;

    public ProductService(ProductMapper mapper, CategoryMapper categoryMapper) {
        this.mapper = mapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Product findOne(Long id) {
        Product product = mapper.findOne(id);
        if (product == null) {
            throw new NotFoundException("Product with id " + id + " doesn't exist");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = mapper.findAll();
        for (int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            List<Category> categories = categoryMapper.getCategoriesForProduct(product.getId());
            product.setCategories(categories);
        }
        return products;
    }

    public List<Product> getProductsForCategory(Long id) {
        List<Product> products = mapper.getProductsForCategory(id);
        for (int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            List<Category> categories = categoryMapper.getCategoriesForProduct(product.getId());
            product.setCategories(categories);
        }
        return products;
    }

    @Override
    public Product insertProduct(Product product) {
        mapper.insertProduct(product);
        for (int i = 0; i < product.getCategoryIds().size(); i++) {
            Long categoryId = product.getCategoryIds().get(i);
            mapper.insertProductCategory(product.getId(), categoryId);
        }
        return product;
    }

//    @Override
//    public void insertProductCategory(Long productId, List<Long> categoryIds) {
//        List<Long> categoryIdsToAdd = new ArrayList<>(categoryIds);
//        List<Long> validCategoryIds = new ArrayList<>();
//        for (int i = 0; i < categoryIdsToAdd.size(); i++) {
//            long categoryId = categoryIds.get(i);
//            if (categoryId == mapper.findSelectedCategoryId(categoryId)) {
//                validCategoryIds.add(categoryId);
//            }
//        }
//
//        if (categoryIdsToAdd.size() == validCategoryIds.size()) {
//            mapper.insertProductCategory(productId, validCategoryIds);
//        }
//    }

    @Override
    public Product update(Product product) {
        mapper.update(product);
        mapper.deleteProductCategories(product.getId());
        for (int i = 0; i < product.getCategoryIds().size(); i++) {
            Long categoryId = product.getCategoryIds().get(i);
            mapper.insertProductCategory(product.getId(), categoryId);
        }
        return product;
    }

    @Override
    public void delete(Long id) {
        mapper.deleteProductCategories(id);
        mapper.delete(id);
    }
}

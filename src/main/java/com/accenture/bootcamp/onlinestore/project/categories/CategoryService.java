package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService implements CategoryRepository {

    private final CategoryMapper mapper;
    private final ProductMapper productMapper;

    public CategoryService(CategoryMapper mapper, ProductMapper productMapper) {
        this.mapper = mapper;
        this.productMapper = productMapper;
    }

    @Override
    public Category findOne(Long id) {
        Category category = mapper.findOne(id);
        if (category == null) {
            throw new NotFoundException("Category with id " + id + " doesn't exist");
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return mapper.findAll();
    }

    public List<Product> getProductsForCategory(Long id) {
        return productMapper.getProductsForCategory(id);
    }

    @Override
    public Category create(Category newCategory) {
//        Category category = new Category(newCategory);
        mapper.create(newCategory);
        return newCategory;
    }

//    @Override
//    public Category update(Long id, CategoryRequest category) {
//        Category existing = findOne(id);
//        existing.setName(category.getName());
//        existing.setImageUri(category.getImageUri());
//        mapper.update(existing);
//        return existing;
//    }

    @Override
    public Category update(Long id, Category category) {
        Category existing = findOne(id);
        existing.setName(category.getName());
        existing.setImageUri(category.getImageUri());
        mapper.update(existing);
        return existing;
    }

    @Override
    public void delete(Long id) {
        mapper.delete(findOne(id));
    }

}

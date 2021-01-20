package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryMapper mapper;

    public Category findOne(Long id) {
        Category category = mapper.findOne(id);
        if (category == null) {
            throw new NotFoundException("Category with id " + id + " doesn't exist");
        }
        return category;
    }

    public String findByName(String name) {
        return mapper.findByName(name);
    }

    public List<Category> findAll() {
        return mapper.findAll();
    }

    public List<String> findAllNames() {
        return mapper.findAllNames();
    }

    public List<Long> getCategoryIdsForProduct(Long productId) {
        return mapper.getCategoryIdsForProduct(productId);
    }

    public Category create(Category newCategory) {
        mapper.create(newCategory);
        return newCategory;
    }

    public Category update(Long id, Category category) {
        Category existing = findOne(id);
        existing.setName(category.getName());
        existing.setImageUri(category.getImageUri());
        mapper.update(existing);
        return existing;
    }

    public void delete(Long id) {
        mapper.delete(findOne(id));
    }

}

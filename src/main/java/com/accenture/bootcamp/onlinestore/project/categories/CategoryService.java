package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService implements CategoryRepository {

    private final CategoryMapper mapper;

    public CategoryService(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Category findOne(long id) {
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

    @Override
    public Category insert(CategoryRequest request) {
        Category category = new Category(request);
        mapper.insert(category);
        return category;
    }

    @Override
    public Category update(long id, CategoryRequest category) {
        Category existing = findOne(id);
        existing.setName(category.getName());
        existing.setImageUri(category.getImageUri());
        mapper.update(existing);
        return existing;
    }

    @Override
    public void delete(long id) {
        mapper.delete(findOne(id));
    }

}

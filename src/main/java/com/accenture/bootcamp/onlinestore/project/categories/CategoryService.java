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
        Category categorie = new Category(request);
        mapper.insert(categorie);
        return categorie;
    }

    @Override
    public Category update(long id, CategoryRequest categorie) {
        Category existing = findOne(id);
        existing.setName(categorie.getName());
        existing.setImageUri(categorie.getImageUri());
        mapper.update(existing);
        return existing;
    }

    @Override
    public void delete(long id) {
        mapper.delete(findOne(id));
    }

}

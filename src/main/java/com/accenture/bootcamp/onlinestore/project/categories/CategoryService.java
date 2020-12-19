package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService implements CategoriesRepository {

    private final CategoriesMapper mapper;

    public CategoryService(CategoriesMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Categories findOne(long id) {
        Categories category = mapper.findOne(id);
        if (category == null){
            throw new NotFoundException("Category with id " + id + " doesn't exist");
        }
        return category;
    }

    @Override
    public List<Categories> findAll() {
        return mapper.findAll();
    }

    @Override
    public Categories insert(CategorieRequest request) {
        Categories categorie = new Categories(request);
        mapper.insert(categorie);
        return categorie;
    }

    @Override
    public Categories update(long id, CategorieRequest categorie) {
        Categories existing = findOne(id);
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

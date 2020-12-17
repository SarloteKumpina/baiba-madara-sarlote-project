package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InMemoryCategoriesRepository implements CategoriesRepository {

    private final CategoriesMapper mapper;

    public InMemoryCategoriesRepository(CategoriesMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Categories findOne(long id) {
        return mapper.findOne(id);
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

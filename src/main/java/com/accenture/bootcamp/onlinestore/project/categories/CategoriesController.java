package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/online-shop/category")
@RestController
public class CategoriesController {

    private final CategoriesRepository repository;

    @Autowired
    public CategoriesController(CategoriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Categories findOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Categories> getCategories() {
        return repository.findAll();
    }

    @PostMapping
    public Categories create(@RequestBody CategorieRequest category) {
        return repository.insert(category);
    }

    @PutMapping("/{id}")
    public Categories update(@PathVariable long id,
                             @RequestBody CategorieRequest categorie) {
        return repository.update(id, categorie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }

}

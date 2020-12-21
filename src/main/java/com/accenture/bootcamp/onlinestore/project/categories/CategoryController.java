package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/online-shop/category")
@RestController
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Category> getCategories() {
        return repository.findAll();
    }

    @PostMapping
    public Category create(@RequestBody CategoryRequest category) {
        return repository.insert(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable long id,
                           @RequestBody CategoryRequest categorie) {
        return repository.update(id, categorie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }

}

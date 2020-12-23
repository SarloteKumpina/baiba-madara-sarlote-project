package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/online-shop/category")
@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryController(CategoryRepository repository, ProductRepository productRepository) {
        this.categoryRepository = repository;
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable long id) {
        return categoryRepository.findOne(id);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //todo do not allow to add, if category by name already exists
    @PostMapping
    public Category create(@RequestBody CategoryRequest category) {
        return categoryRepository.insert(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable long id,
                           @RequestBody CategoryRequest category) {
        return categoryRepository.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryRepository.delete(id);
    }
}

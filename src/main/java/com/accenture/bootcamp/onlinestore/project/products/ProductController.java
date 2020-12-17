package com.accenture.bootcamp.onlinestore.project.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories/products")
@RestController
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Products findOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Products> getProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Products create(@RequestBody ProductRequest product) {
        return repository.insert(product);
    }

    @PutMapping("/{id}")
    public Products update(@PathVariable long id,
                           @RequestBody ProductRequest product) {
        return repository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }
}
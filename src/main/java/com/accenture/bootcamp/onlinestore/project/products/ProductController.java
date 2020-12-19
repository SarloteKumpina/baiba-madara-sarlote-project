package com.accenture.bootcamp.onlinestore.project.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/online-shop/product")
@RestController
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody ProductRequest product) {
        return repository.insertProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable long id,
                          @RequestBody ProductRequest product) {
        return repository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }
}
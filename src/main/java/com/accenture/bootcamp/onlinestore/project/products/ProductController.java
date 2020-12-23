package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/online-shop/product")
@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository repository, CategoryRepository categoryRepository) {
        this.productRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable long id) {
        return productRepository.findOne(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody ProductRequest product) {
        return productRepository.insertProduct(product);
    }

//    @PostMapping("/category")
//    public void insertCategoryIds(@RequestBody long productId, List<Long> categoryIds) {
//        repository.insertProductCategory(productId, categoryIds);
//    }

    @PutMapping("/{id}")
    public Product update(@PathVariable long id,
                          @RequestBody ProductRequest product) {
        return productRepository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productRepository.delete(id);
    }
}
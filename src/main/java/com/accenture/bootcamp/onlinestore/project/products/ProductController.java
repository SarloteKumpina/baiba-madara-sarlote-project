package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@RequestMapping("/online-shop/product")
@Controller
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

    @GetMapping ("/admin/products")
    public String getProducts(Model model) {
        List<Product> products = productRepository.findAll();
        /*Product testProduct = new Product(65, "Boot", Arrays.asList(1L, 2L), new BigDecimal(10.00),   ////test, remove later
                "brown", 8, "https://www.bikebiz.com.au/pub/media/catalog/product/cache/74b7b62b2c2d56f5d0eca97abb7036f2/k/a/kaspar800px-brown_1543429045_1.jpg");
        ArrayList<Product> testProductsList = new ArrayList<>();   ////test, remove later
        testProductsList.add(testProduct); ////test, remove later*/
        model.addAttribute("products", products);
        return "cms/products/products";
    }

    @GetMapping("/admin/products/new")
    public String showProductForm(Model model) {
        //model.addAttribute("frontProduct", new AddedProductData());
        //model.addAttribute("options", categoriesService.categories());
        return "cms/products/create-edit-product";
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
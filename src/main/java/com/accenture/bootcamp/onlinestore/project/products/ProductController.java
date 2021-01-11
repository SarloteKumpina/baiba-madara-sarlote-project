package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public Product findOne(@PathVariable Long id) {
        return productRepository.findOne(id);
    }

    @GetMapping(path = {"/admin/products", "/admin/products/by-category/{categoryId}"})
    public String getProducts(@PathVariable(required = false) Long categoryId, Model model) {
        List<Product> products;
        Category category;
        if (categoryId == null) {
            products = productRepository.findAll();
            model.addAttribute("products", products);
            return "cms/products/products";
        } else {
            category = categoryRepository.findOne(categoryId);
            products = productRepository.getProductsForCategory(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("products", products);
            return "cms/products/products-by-category";
        }
    }

    @GetMapping("/admin/products/new")
    public String showProductForm(Model model) {
        Product product = new Product();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("productToCreate", product);
        model.addAttribute("categories", categories);
        return "cms/products/create-product";
    }

    @PostMapping("/admin/products/new")
    public String saveProduct(Product product) {
        productRepository.insertProduct(product);
        return "redirect:/admin/products";
    }

//    @PostMapping("/category")
//    public void insertCategoryIds(@RequestBody long productId, List<Long> categoryIds) {
//        repository.insertProductCategory(productId, categoryIds);
//    }

    @GetMapping("/admin/products/update/{id}")
    public String displayProductUpdateForm(@PathVariable("id") Long id, Model model) {
        Product productForUpdate = productRepository.findOne(id);
        List<Long> categoryIdsForProduct = categoryRepository.getCategoryIdsForProduct(id);
        productForUpdate.setCategoryIds(categoryIdsForProduct);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("productForUpdate", productForUpdate);
        model.addAttribute("categories", categories);
        return "cms/products/update-product";
    }

    @PostMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, Product product) {
        productRepository.update(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
        return "redirect:/admin/products";
    }
}
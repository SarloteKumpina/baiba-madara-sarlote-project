package com.accenture.bootcamp.onlinestore.project.products;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RequestMapping("/online-shop/product")
@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

/*    @Autowired
    public ProductController(ProductRepository repository, CategoryService categoryService) {
        this.productRepository = repository;
        this.categoryService = categoryService;
    }*/

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
            category = categoryService.findOne(categoryId);
            products = productRepository.getProductsForCategory(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("products", products);
            return "cms/products/products-by-category";
        }
    }

    @GetMapping("/admin/products/new")
    public String showProductForm(Model model, Product product) {
//        Product product = new Product();
        List<Category> categories = categoryService.findAll();
//        model.addAttribute("productToCreate", product);
        model.addAttribute("categories", categories);
        return "cms/products/create-product";
    }

    @PostMapping("/admin/products/new")
    public String saveProduct(Model model, @Valid Product product, BindingResult result) {
        String name = product.getName();
        List<String> allNamesForProducts = productRepository.findAllNames();
        if(product.productIsNew() && allNamesForProducts.contains(name)){
            result.rejectValue("name", "duplicate", "Product with this name already exists.");
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "cms/products/create-product";
        } else if (result.hasErrors()){
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "cms/products/create-product";
        }
        productRepository.insertProduct(product);
        return "redirect:/admin/products";
    }

//    @PostMapping("/category")
//    public void insertCategoryIds(@RequestBody long productId, List<Long> categoryIds) {
//        repository.insertProductCategory(productId, categoryIds);
//    }

    @GetMapping("/admin/products/update/{id}")
    public String displayProductUpdateForm(@PathVariable("id") Long id, Model model, Product product) {
        Product productForUpdate = productRepository.findOne(id);
        List<Long> categoryIdsForProduct = categoryService.getCategoryIdsForProduct(id);
        productForUpdate.setCategoryIds(categoryIdsForProduct);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product", productForUpdate);
        model.addAttribute("categories", categories);
        return "cms/products/update-product";
    }

    @PostMapping("/admin/products/update")
    public String updateProduct(Model model, @Valid Product product, BindingResult result) {
        if (result.hasErrors()){
            List<Category> categories = categoryService.findAll();
            //model.addAttribute("productForUpdate", product);
            model.addAttribute("categories", categories);
            return "cms/products/update-product";
        }
        productRepository.update(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
        return "redirect:/admin/products";
    }
}
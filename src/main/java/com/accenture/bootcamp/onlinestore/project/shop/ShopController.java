package com.accenture.bootcamp.onlinestore.project.shop;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryService;
import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShopController {
    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    @Autowired
    public ShopController(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    @GetMapping(path = {"", "/index"})
    public String shopHome() {
        return "shop/index";
    }

    @GetMapping("/about")
    public String shopAbout() {
        return "shop/about";
    }

    @GetMapping(path = {"/shop", "/categories", "/categories/{categoryId}"})
    public String shopByCategories(@PathVariable(required = false) Long categoryId, Model model) {
        if (categoryId == null) {
            List<Category> allCategories = categoryService.findAll();
            model.addAttribute("allCategories", allCategories);
            List<Product> products = productRepository.findAll();
            model.addAttribute("products", products);
            return "shop/shop";
        } else {
            List<Category> allCategories = categoryService.findAll();
            model.addAttribute("allCategories", allCategories);
            Category category = categoryService.findOne(categoryId);
            model.addAttribute("category", category);
            List<Product> products = productRepository.getProductsForCategory(categoryId);
            model.addAttribute("products", products);
            return "shop/shop-by-categories";
        }
    }

    @GetMapping("/products/{productId}")
    public String productDetail(@PathVariable(required = true) Long productId, Model model) {
        Product product = productRepository.findOne(productId);
        model.addAttribute("product", product);
        return "shop/shop-detail";
    }

    @GetMapping("/cart")
    public String ShopCart() {
        return "shop/cart";
    }

    @GetMapping("/checkout")
    public String ShopCheckout() {
        return "shop/checkout";
    }

    @GetMapping("/service")
    public String ShopService() {
        return "shop/service";
    }

    @GetMapping("/contact-us")
    public String ShopContact() {
        return "shop/contact-us";
    }
}

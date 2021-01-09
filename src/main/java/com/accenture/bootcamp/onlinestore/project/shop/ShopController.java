package com.accenture.bootcamp.onlinestore.project.shop;

import com.accenture.bootcamp.onlinestore.project.categories.Category;
import com.accenture.bootcamp.onlinestore.project.categories.CategoryRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShopController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
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

    @GetMapping(path = {"/shop/{categoryName}", "/shop"})
    public String shopProduct(@PathVariable(required = false) String categoryName, Model model) {
        System.out.println(categoryName);
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/shop";
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


    @GetMapping("/test")
    public String testCategoriesList(Model model) {
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "shop/shopLooks/categories";
    }

    @GetMapping("/test2")
    public String testProductsList(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/shopLooks/productslist";
    }

    @GetMapping("/test3")
    public String testProductsList3(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/shopLooks/productsgrid";
    }

    @GetMapping("/test4")
    public String testProductsList4(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/shopLooks/listgridviewfromw3schools";
    }

    @GetMapping("/test5")
    public String testProductsList5(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop/shopLooks/expandinggridfromw3schools";
    }
}

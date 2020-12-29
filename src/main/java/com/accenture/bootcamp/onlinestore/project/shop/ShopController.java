package com.accenture.bootcamp.onlinestore.project.shop;

import com.accenture.bootcamp.onlinestore.project.categories.CategoryRepository;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShopController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public String ShopHome(){
        return "shop/index";
    }

}

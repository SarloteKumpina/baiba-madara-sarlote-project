package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryController(CategoryRepository repository, ProductRepository productRepository) {
        this.categoryRepository = repository;
        this.productRepository = productRepository;
    }

    @GetMapping(path = {"/admin/categories", "/admin"})
    public String getAllCategories(Model model) {
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "cms/categories/categories";
    }

    @GetMapping("/admin/categories/create")
    public String displayCategoryCreateForm(Model model) {
        Category categoryToCreate = new Category();
        model.addAttribute("categoryToCreate", categoryToCreate);
        return "cms/categories/create-category";
    }

    @PostMapping("/admin/categories/create")
    public String createCategory(Category category) {
        categoryRepository.create(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String displayCategoryUpdateForm(@PathVariable("id") Long id, Model model) {
        Category categoryForUpdate = categoryRepository.findOne(id);
        model.addAttribute("categoryForUpdate", categoryForUpdate);
        return "cms/categories/update-category";
    }

    @PostMapping("/admin/categories/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Long id, Category category) {
        categoryRepository.update(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryRepository.delete(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/{categoryId}")
    public String showCategory(@PathVariable("categoryId") Long id,
                               Model model) {
        Category category = categoryRepository.findOne(id);
        List<Product> products = categoryRepository.getProductsForCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "cms/categories/category-details";
    }



}

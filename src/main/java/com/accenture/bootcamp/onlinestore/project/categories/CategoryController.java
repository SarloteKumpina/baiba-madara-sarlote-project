package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    @GetMapping(path = {"/admin/categories", "/admin"})
    public String getAllCategories(Model model) {
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "cms/categories/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String displayCategoryUpdateForm(@PathVariable("id") long id, Model model) {
        Category categoryForUpdate = categoryRepository.findOne(id);
        model.addAttribute("categoryForUpdate", categoryForUpdate);
        return "cms/categories/update-category";
    }

    @PostMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable("id") long id, Category category) {
        categoryRepository.update(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        categoryRepository.delete(id);
        return "redirect:/admin/categories";
    }

}

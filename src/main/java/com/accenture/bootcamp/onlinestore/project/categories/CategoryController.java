package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;
import java.util.List;

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

    @GetMapping("/admin/categories/create")
    public String displayCategoryCreateForm(Model model) {
        Category categoryToCreate = new Category();
        model.addAttribute("categoryToCreate", categoryToCreate);
        return "cms/categories/create-category";
    }

    @PostMapping("/admin/categories/create")
    public String createCategory(Category category) {
        String name = categoryRepository.findByName(category.getName());
        List<String> allNamesForCategories = categoryRepository.findAllNames();
        if (category.categoryIsNew() && allNamesForCategories.contains(name)) {
            return "redirect:/admin/categories";
        } else if (name == null) {
            return "redirect:/admin/categories";
        } else {
            categoryRepository.create(category);
            return "redirect:/admin/categories";
        }
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

}

package com.accenture.bootcamp.onlinestore.project.categories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = {"/admin/categories", "/admin"})
    public String getAllCategories(Model model) {
        List<Category> allCategories = categoryService.findAll();
        model.addAttribute("allCategories", allCategories);
        return "cms/categories/categories";
    }

    @GetMapping("/admin/categories/create")
    public String displayCategoryCreateForm(Category category) {
        return "cms/categories/create-category";
    }

    @PostMapping("/admin/categories/create")
    public String createCategory(@Valid Category category, BindingResult result) {
        String name = category.getName();
        List<String> allNamesForCategories = categoryService.findAllNames();
        if (category.categoryIsNew() && allNamesForCategories.contains(name)) {
            result.rejectValue("name", "duplicate", "Category with this name already exists.");
            return "cms/categories/create-category";
        } else if (result.hasErrors()) {
            return "cms/categories/create-category";
        }
        categoryService.create(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String displayCategoryUpdateForm(@PathVariable("id") Long id, Model model, Category category) {
        Category categoryForUpdate = categoryService.findOne(id);
        model.addAttribute("category", categoryForUpdate);
        model.addAttribute("currentCategoryName", categoryForUpdate.getName());
        return "cms/categories/update-category";
    }

    @PostMapping("/admin/categories/update")
    public String updateCategory(Model model, @Valid Category category, BindingResult result) {
        String name = category.getName();
        String previousName = (String) model.getAttribute("currentCategoryName");
        List<String> allNamesForCategories = categoryService.findAllNames();
        if (!name.equals(previousName) && allNamesForCategories.contains(name)) {
            result.rejectValue("name", "duplicate", "Category with this name already exists.");
            return "cms/categories/update-category";
        } else if (result.hasErrors()) {
            return "cms/categories/update-category";
        }
        categoryService.update(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }

}

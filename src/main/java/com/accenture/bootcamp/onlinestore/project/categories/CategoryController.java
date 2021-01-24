package com.accenture.bootcamp.onlinestore.project.categories;

import com.accenture.bootcamp.onlinestore.project.products.Product;
import com.accenture.bootcamp.onlinestore.project.products.ProductRepository;
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
    private final ProductRepository productRepository;

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
        int categoryNameCount = categoryService.findHowManyTimesCategoryNameAppears(name);
        if (category.categoryIsNew() && categoryNameCount > 0) {
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
        return "cms/categories/update-category";
    }

    @PostMapping("/admin/categories/update")
    public String updateCategory(@Valid Category category, BindingResult result) {
        String name = category.getName();
        Category currentCategory = categoryService.findOne(category.getId());
        String currentCategoryName = currentCategory.getName();
        int categoryNameCount = categoryService.findHowManyTimesCategoryNameAppears(name);
        if (!name.equals(currentCategoryName) && categoryNameCount > 0) {
            result.rejectValue("name", "duplicate", "Category with this name already exists.");
            return "cms/categories/update-category";
        } else if (result.hasErrors()) {
            return "cms/categories/update-category";
        }
        categoryService.update(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(Model model, @PathVariable("id") Long id) {
        List<Product> productsForCategory = productRepository.getProductsForCategory(id);
        if (!productsForCategory.isEmpty()) {
            List<Category> allCategories = categoryService.findAll();
            Category categoryToDelete = categoryService.findOne(id);
            model.addAttribute("allCategories", allCategories);
            model.addAttribute("isError1", true);
            model.addAttribute("errorCategoryName", categoryToDelete.getName());
            model.addAttribute("productCount", productsForCategory.size());
            return "cms/categories/categories";
        } else {
            categoryService.delete(id);
            return "redirect:/admin/categories";
        }
    }
}

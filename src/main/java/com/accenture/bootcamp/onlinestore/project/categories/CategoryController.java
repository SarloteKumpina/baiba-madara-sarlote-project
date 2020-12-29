package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
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
    public String getAllCategories(Model model){
        List<Category> allCategories = categoryRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        return "cms/categories/categories";
    }

    @GetMapping("admin/categories/new")
    public String displayCategoryForm(Category category){
        return "cms/categories/create-edit-category";
    }

    @PostMapping("/admin/categories/new")
    public String addNewCategory(@Valid CategoryRequest category, BindingResult result){
        if (result.hasErrors()) {
            return "categories/create-category";
        } else {
            categoryRepository.insert(category);
            return "redirect:/admin/categories";
        }
    }



//    @GetMapping(path = {"/admin/categories", "/admin"})
//    public String getAllCategories(Model model){
//        model.addAttribute("allCategories", categoryRepository.findAll());
//        return "cms/categories/categories";
//    }

}

//    @GetMapping("/{id}")
//    public Category findOne(@PathVariable long id) {
//        return categoryRepository.findOne(id);
//    }
//
//    @GetMapping
//    public List<Category> getCategories() {
//        return categoryRepository.findAll();
//    }
//
//    //todo do not allow to add, if category by name already exists
//    @PostMapping
//    public Category create(@RequestBody CategoryRequest category) {
//        return categoryRepository.insert(category);
//    }
//
//    @PutMapping("/{id}")
//    public Category update(@PathVariable long id,
//                           @RequestBody CategoryRequest category) {
//        return categoryRepository.update(id, category);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        categoryRepository.delete(id);
//    }
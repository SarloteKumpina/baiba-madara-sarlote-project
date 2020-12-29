package com.accenture.bootcamp.onlinestore.project.categories;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

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
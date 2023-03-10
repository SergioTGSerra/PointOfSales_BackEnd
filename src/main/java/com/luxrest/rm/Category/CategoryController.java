package com.luxrest.rm.Category;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category saveCategory(@RequestBody @Valid Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable long id, @RequestBody @Valid Category category){
        return categoryService.updateCategory(id, category);
    }
}
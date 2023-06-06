package com.luxrest.rm.Category;

import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findByIsDeletedFalse();
    }
    @Transactional
    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + id));
    }
    @Transactional
    public Category saveCategory(Category category){
        if(category.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        return categoryRepository.save(category);
    }
    @Transactional
    public Category updateCategory(Integer id, Category category){
        categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        category.setId(id);
        return categoryRepository.save(category);
    }
    @Transactional
    public Category deleteCategory(Integer id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        List<Product> products = productRepository.findByCategoryId(id);
        if (!products.isEmpty()) {
            throw new IllegalStateException("Cannot delete category. There are associated products.");
        }

        category.setIsDeleted(false);
        return categoryRepository.save(category);
    }
}
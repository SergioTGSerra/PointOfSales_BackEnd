package com.luxrest.rm.Category;

import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findByIsDeletedFalse();

        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public CategoryDTO getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + id));
        return categoryMapper.toDTO(category);
    }

    @Transactional
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getId() != null) {
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        }
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Transactional
    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        if (categoryDTO.getName() != null)
            existingCategory.setName(categoryDTO.getName());
        if (categoryDTO.getDescription() != null)
            existingCategory.setDescription(categoryDTO.getDescription());

        Category savedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toDTO(savedCategory);
    }

    @Transactional
    public CategoryDTO deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        List<Product> products = productRepository.findByCategoryId(id);
        if (!products.isEmpty()) {
            throw new IllegalStateException("Cannot delete category. There are associated products.");
        }

        category.setIsDeleted(true);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }
}

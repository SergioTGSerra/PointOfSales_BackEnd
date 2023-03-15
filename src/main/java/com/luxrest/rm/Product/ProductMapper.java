package com.luxrest.rm.Product;

import com.luxrest.rm.Category.CategoryService;
import com.luxrest.rm.Tax.TaxService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final CategoryService categoryService;
    private final TaxService taxService;
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setIsActive(product.getIsActive());
        productDTO.setIsDeleted(product.getIsDeleted());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setTaxId(product.getTax().getId());
        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setIsActive(productDTO.getIsActive());
        product.setIsDeleted(productDTO.getIsDeleted());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()));
        product.setTax(taxService.getTaxById(productDTO.getTaxId()));
        return product;
    }
}

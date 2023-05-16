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
    public ProductResponse toDTO(Product product) {
        ProductResponse productDTO = new ProductResponse();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setIsActive(product.getIsActive());
        productDTO.setImage(product.getImage());
        productDTO.setCategory(String.valueOf(product.getCategory().getId()));
        productDTO.setTax(Double.valueOf(product.getTax().getId()));
        return productDTO;
    }

    public Product toEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setIsActive(productRequest.getIsActive());
        product.setCategory(categoryService.getCategoryById(productRequest.getCategory()));
        product.setTax(taxService.getTaxById(productRequest.getTax()));
        return product;
    }
}

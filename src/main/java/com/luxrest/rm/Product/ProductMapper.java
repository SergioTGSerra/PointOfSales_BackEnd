package com.luxrest.rm.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
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
        return product;
    }
}

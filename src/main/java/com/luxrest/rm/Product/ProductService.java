package com.luxrest.rm.Product;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO getProductById(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ id));
        return productMapper.toDTO(product);
    }

    @Transactional
    public List<ProductDTO> getProductsByCategoryId(Integer categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        if(productDTO.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product));
    }

    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO){
        productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ id));
        Product product = productMapper.toEntity(productDTO);
        product.setId(id);
        return productMapper.toDTO(productRepository.save(product));
    }

    @Transactional
    public ProductDTO deleteProduct(Integer id){
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found" + id));
        deletedProduct.setIsDeleted(true);
        return productMapper.toDTO(productRepository.save(deletedProduct));
    }
}
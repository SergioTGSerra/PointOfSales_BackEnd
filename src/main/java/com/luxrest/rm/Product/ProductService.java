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

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse getProductById(Integer id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ id));
        return productMapper.toDTO(product);
    }

    @Transactional
    public List<ProductResponse> getProductsByCategoryId(Integer categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);
        return productMapper.toDTO(productRepository.save(product));
    }

    @Transactional
    public ProductResponse updateProduct(Integer id, ProductRequest productRequest){
        productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ id));
        Product product = productMapper.toEntity(productRequest);
        return productMapper.toDTO(productRepository.save(product));
    }

    @Transactional
    public ProductResponse deleteProduct(Integer id){
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found" + id));
        deletedProduct.setIsDeleted(true);
        return productMapper.toDTO(productRepository.save(deletedProduct));
    }
}
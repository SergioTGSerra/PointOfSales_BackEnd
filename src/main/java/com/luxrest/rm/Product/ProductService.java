package com.luxrest.rm.Product;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findByIsDeletedFalse();
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
    public ProductResponse createProduct(
            ProductRequest productRequest,
            MultipartFile file
    ) throws IOException {
        if (file == null || !Objects.equals(file.getContentType(), "image/png"))
            throw new IllegalArgumentException("O arquivo deve ser uma imagem PNG.");
        Product product = productMapper.toEntity(productRequest);
        product.setImage(file.getBytes());
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
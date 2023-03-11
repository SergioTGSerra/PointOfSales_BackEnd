package com.luxrest.rm.Product;

import com.luxrest.rm.Category.CategoryService;
import com.luxrest.rm.Tax.TaxService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final TaxService taxService;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryService categoryService, TaxService taxService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
        this.taxService = taxService;
    }

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
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()));
        product.setTax(taxService.getTaxById(productDTO.getTaxId()));
        Product createdProduct = productRepository.save(product);
        return productMapper.toDTO(createdProduct);
    }

    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ id));
        updateProduct.setName(productDTO.getName());
        updateProduct.setPrice(productDTO.getPrice());
        updateProduct.setStock(productDTO.getStock());
        updateProduct.setIsActive(productDTO.getIsActive());
        updateProduct.setIsDeleted(productDTO.getIsDeleted());
        updateProduct.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()));
        updateProduct.setTax(taxService.getTaxById(productDTO.getTaxId()));
        return productMapper.toDTO(productRepository.save(updateProduct));
    }

    @Transactional
    public ProductDTO deleteProduct(Integer id){
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found" + id));
        deletedProduct.setIsDeleted(true);
        return productMapper.toDTO(productRepository.save(deletedProduct));
    }
}
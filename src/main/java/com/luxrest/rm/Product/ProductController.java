package com.luxrest.rm.Product;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getProductByCategoryId(@PathVariable Integer id){
        return  ResponseEntity.ok(productService.getProductsByCategoryId(id));
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }
    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

}
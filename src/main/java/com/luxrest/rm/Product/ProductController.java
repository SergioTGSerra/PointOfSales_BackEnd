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
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductResponse>> getProductByCategoryId(@PathVariable Integer id){
        return  ResponseEntity.ok(productService.getProductsByCategoryId(id));
    }
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest){
        return productService.updateProduct(id, productRequest);
    }
    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

}
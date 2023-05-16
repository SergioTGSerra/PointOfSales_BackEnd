package com.luxrest.rm.Product;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<ProductResponse> createProduct(
            @RequestPart("json") @Valid ProductRequest productRequest,
            @RequestPart("image") MultipartFile file)
            throws IOException {
        return ResponseEntity.ok(
                productService.createProduct(productRequest, file)
        );
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest){
        return productService.updateProduct(id, productRequest);
    }
    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        ProductResponse product = productService.getProductById(id);

        if (product.getImage() == null || product.getImage().length == 0) {
            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + product.getName() + "\"")
                .contentType(MediaType.valueOf("image/png"))
                .body(product.getImage());
    }
}
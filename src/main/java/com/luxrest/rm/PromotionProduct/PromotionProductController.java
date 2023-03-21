package com.luxrest.rm.PromotionProduct;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotionProduct")
@AllArgsConstructor
public class PromotionProductController {

    private final PromotionProductService promotionProductService;

    @GetMapping
    public ResponseEntity<List<PromotionProductDTO>> getAllPromotionProducts() {
       return ResponseEntity.ok(promotionProductService.getAllPromotionProducts());
    }

    @GetMapping("/{id}")
    public PromotionProductDTO getPromotionProductById(@PathVariable Integer id){
        return promotionProductService.getPromotionProductById(id);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<PromotionProductDTO>> getPromotionProductByProductId(@PathVariable Integer id){
        return  ResponseEntity.ok(promotionProductService.getPromotionProductsByProductId(id));
    }

    @PostMapping
    public ResponseEntity<PromotionProductDTO> createPromotionProduct(@RequestBody PromotionProductDTO promotionProductDTO){
        return ResponseEntity.ok(promotionProductService.createPromotionProduct(promotionProductDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionProductDTO> updatePromotionProduct(@PathVariable Integer id, @RequestBody PromotionProductDTO promotionProductDTO){
        return ResponseEntity.ok(promotionProductService.updatePromotionProduct(id, promotionProductDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PromotionProductDTO> deletePromotionProduct(@PathVariable Integer id){
        return ResponseEntity.ok(promotionProductService.deletePromotionProduct(id));
    }
}
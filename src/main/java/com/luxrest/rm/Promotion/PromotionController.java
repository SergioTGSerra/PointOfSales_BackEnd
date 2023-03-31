package com.luxrest.rm.Promotion;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotion")
@AllArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping
    public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
       return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getPromotionById(@PathVariable Integer id){
        return ResponseEntity.ok(promotionService.getPromotionById(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<PromotionDTO>> getPromotionByProductId(@PathVariable Integer id){
        return  ResponseEntity.ok(promotionService.getPromotionByProductId(id));
    }

    @GetMapping("/pack/{id}")
    public ResponseEntity<List<PromotionDTO>> getPromotionByPackId(@PathVariable Integer id){
        return  ResponseEntity.ok(promotionService.getPromotionByPackId(id));
    }

    @PostMapping
    public ResponseEntity<PromotionDTO> createPromotionProduct(@RequestBody PromotionDTO promotionDTO){
        return ResponseEntity.ok(promotionService.createPromotion(promotionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionDTO> updatePromotionProduct(@PathVariable Integer id, @RequestBody PromotionDTO promotionDTO){
        return ResponseEntity.ok(promotionService.updatePromotion(id, promotionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PromotionDTO> deletePromotionProduct(@PathVariable Integer id){
        return ResponseEntity.ok(promotionService.deletePromotion(id));
    }
}
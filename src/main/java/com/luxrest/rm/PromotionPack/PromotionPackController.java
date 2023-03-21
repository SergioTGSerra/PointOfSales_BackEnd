package com.luxrest.rm.PromotionPack;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotionPack")
@AllArgsConstructor
public class PromotionPackController {
    private final PromotionPackService promotionPackService;

    @GetMapping
    public ResponseEntity<List<PromotionPackDTO>> getAllPromotionPack() {
        return ResponseEntity.ok(promotionPackService.getAllPromotionPacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionPackDTO> getPromotionPack(@PathVariable Integer id) {
        return ResponseEntity.ok(promotionPackService.getPromotionPackById(id));
    }

    @GetMapping("/pack/{id}")
    public ResponseEntity<List<PromotionPackDTO>> getPromotionPackByPackId(@PathVariable Integer id){
        return  ResponseEntity.ok(promotionPackService.getPromotionPackByPackId(id));
    }

    @PostMapping
    public ResponseEntity<PromotionPackDTO> createPromotionPack(@RequestBody PromotionPackDTO promotionPackDTO){
        return ResponseEntity.ok(promotionPackService.createPromotionPack(promotionPackDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionPackDTO> updatePromotionPack(@PathVariable Integer id, @RequestBody PromotionPackDTO promotionPackDTO){
        return ResponseEntity.ok(promotionPackService.updatePromotionPack(id, promotionPackDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PromotionPackDTO> deletePromotionPack(@PathVariable Integer id){
        return ResponseEntity.ok(promotionPackService.deletePromotionPack(id));
    }
}
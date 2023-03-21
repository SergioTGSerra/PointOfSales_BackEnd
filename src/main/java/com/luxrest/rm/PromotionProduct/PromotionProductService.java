package com.luxrest.rm.PromotionProduct;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionProductService {
    private final PromotionProductRepository promotionProductRepository;
    private final PromotionProductMapper promotionProductMapper;

    public List<PromotionProductDTO> getAllPromotionProducts() {
        List<PromotionProduct> promotionProducts = promotionProductRepository.findAll();
        return promotionProducts.stream()
                .map(promotionProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionProductDTO getPromotionProductById(Integer id){
        PromotionProduct promotionProduct = promotionProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Product not found"+ id));
        return promotionProductMapper.toDTO(promotionProduct);
    }

    @Transactional
    public List<PromotionProductDTO> getPromotionProductsByProductId(Integer productId) {
        List<PromotionProduct> promotionProducts = promotionProductRepository.findByProduct_Id(productId);
        return promotionProducts.stream()
                .map(promotionProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionProductDTO createPromotionProduct(PromotionProductDTO promotionProductDTO){
        PromotionProduct promotionProduct = promotionProductMapper.toEntity(promotionProductDTO);
        promotionProduct.setIsDeleted(false);
        return  promotionProductMapper.toDTO(promotionProductRepository.save(promotionProduct));
    }

    @Transactional
    public PromotionProductDTO updatePromotionProduct(Integer id, PromotionProductDTO promotionProductDTO){
        promotionProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Product not found"+ id));
        PromotionProduct promotionProduct = promotionProductMapper.toEntity(promotionProductDTO);
        promotionProduct.setIdPromotion(id);
        return promotionProductMapper.toDTO(promotionProductRepository.save(promotionProduct));
    }

    @Transactional
    public PromotionProductDTO deletePromotionProduct(Integer id){
        PromotionProduct promotionProduct = promotionProductRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Product not found" + id));
        promotionProduct.setIsDeleted(true);
        return promotionProductMapper.toDTO(promotionProductRepository.save(promotionProduct));
    }
}
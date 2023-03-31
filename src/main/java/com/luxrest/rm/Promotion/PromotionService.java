package com.luxrest.rm.Promotion;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final PromotionMapper promotionMapper;

    public List<PromotionDTO> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotions.stream()
                .map(promotionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionDTO getPromotionById(Integer id){
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found"+ id));
        return promotionMapper.toDTO(promotion);
    }

    @Transactional
    public List<PromotionDTO> getPromotionByProductId(Integer productId) {
        List<Promotion> promotionProducts = promotionRepository.findByProduct_Id(productId);
        return promotionProducts.stream()
                .map(promotionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PromotionDTO> getPromotionByPackId(Integer packId) {
        List<Promotion> promotionPacks = promotionRepository.findByPack_Id(packId);
        return promotionPacks.stream()
                .map(promotionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionDTO createPromotion(PromotionDTO promotionDTO){
        Promotion promotion = promotionMapper.toEntity(promotionDTO);
        promotion.setIsDeleted(false);
        return  promotionMapper.toDTO(promotionRepository.save(promotion));
    }

    @Transactional
    public PromotionDTO updatePromotion(Integer id, PromotionDTO promotionDTO){
        promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found"+ id));
        Promotion promotion = promotionMapper.toEntity(promotionDTO);
        promotion.setIdPromotion(id);
        return promotionMapper.toDTO(promotionRepository.save(promotion));
    }

    @Transactional
    public PromotionDTO deletePromotion(Integer id){
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found" + id));
        promotion.setIsDeleted(true);
        return promotionMapper.toDTO(promotionRepository.save(promotion));
    }
}
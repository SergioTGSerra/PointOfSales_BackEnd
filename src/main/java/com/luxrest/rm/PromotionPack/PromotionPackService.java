package com.luxrest.rm.PromotionPack;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PromotionPackService {
    private final PromotionPackRepository promotionPackRepository;
    private final PromotionPackMapper promotionPackMapper;

    public List<PromotionPackDTO> getAllPromotionPacks() {
        List<PromotionPack> promotionPacks = promotionPackRepository.findAll();
        return promotionPacks.stream()
                .map(promotionPackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionPackDTO getPromotionPackById(Integer id){
        PromotionPack promotionPack = promotionPackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Product not found"+ id));
        return promotionPackMapper.toDTO(promotionPack);
    }

    @Transactional
    public List<PromotionPackDTO> getPromotionPackByPackId(Integer packId) {
        List<PromotionPack> promotionPacks = promotionPackRepository.findByPack_Id(packId);
        return promotionPacks.stream()
                .map(promotionPackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PromotionPackDTO createPromotionPack(PromotionPackDTO promotionPackDTO){
        PromotionPack promotionPack = promotionPackMapper.toEntity(promotionPackDTO);
        promotionPack.setIsDeleted(false);
        return  promotionPackMapper.toDTO(promotionPackRepository.save(promotionPack));
    }

    @Transactional
    public PromotionPackDTO updatePromotionPack(Integer id, PromotionPackDTO promotionPackDTO){
        promotionPackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Pack not found"+ id));
        PromotionPack promotionPack = promotionPackMapper.toEntity(promotionPackDTO);
        promotionPack.setIdPromotion(id);
        return promotionPackMapper.toDTO(promotionPackRepository.save(promotionPack));
    }

    @Transactional
    public PromotionPackDTO deletePromotionPack(Integer id){
        PromotionPack promotionPack = promotionPackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion Pack not found" + id));
        promotionPack.setIsDeleted(true);
        return promotionPackMapper.toDTO(promotionPackRepository.save(promotionPack));
    }
}
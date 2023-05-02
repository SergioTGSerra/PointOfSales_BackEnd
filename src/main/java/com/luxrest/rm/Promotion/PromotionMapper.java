package com.luxrest.rm.Promotion;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionMapper {


    public PromotionDTO toDTO(Promotion promotion) {
        PromotionDTO promotionProductDTO = new PromotionDTO();

        promotionProductDTO.setId(promotion.getId());
        promotionProductDTO.setPrice(promotion.getPrice());
        promotionProductDTO.setIsActive(promotion.getIsActive());
        promotionProductDTO.setIsDeleted(promotion.getIsDeleted());
        promotionProductDTO.setIdProduct(promotion.getProduct().getId());
        promotionProductDTO.setIdPack(promotion.getPack().getId());
        promotionProductDTO.setFinishedAt(promotion.getFinishedAt());
        promotionProductDTO.setCreatedAt(promotion.getCreatedAt());

        return promotionProductDTO;
    }

    public Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();

        promotion.setPrice(promotionDTO.getPrice());
        promotion.setIsActive(promotionDTO.getIsActive());
        promotion.setIsDeleted(promotionDTO.getIsDeleted());
//        promotion.setProduct(productMapper.toEntity(productService.getProductById(promotionDTO.getIdProduct())));
//        promotion.setPack(packMapper.toEntity(packService.getPackById(promotionDTO.getIdPack())));
        promotion.setFinishedAt(promotionDTO.getFinishedAt());
        promotion.setCreatedAt(promotionDTO.getCreatedAt());

        return promotion;
    }
}
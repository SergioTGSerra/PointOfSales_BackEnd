package com.luxrest.rm.PromotionPack;

import com.luxrest.rm.Entity.EntityService;
import com.luxrest.rm.Pack.PackMapper;
import com.luxrest.rm.Pack.PackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionPackMapper {
    private final EntityService entityService;
    private final PackService packService;
    private final PackMapper packMapper;

    public PromotionPackDTO toDTO(PromotionPack promotionPack) {
        PromotionPackDTO promotionPackDTO = new PromotionPackDTO();

        promotionPackDTO.setIdPromotion(promotionPack.getIdPromotion());
        promotionPackDTO.setPrice(promotionPack.getPrice());
        promotionPackDTO.setIsActive(promotionPack.getIsActive());
        promotionPackDTO.setIsDeleted(promotionPack.getIsDeleted());
        promotionPackDTO.setIdPack(promotionPack.getPack().getId());
        promotionPackDTO.setCreatedBy(promotionPack.getCreatedBy().getId());
        promotionPackDTO.setFinishedAt(promotionPack.getFinishedAt());
        promotionPackDTO.setCreatedAt(promotionPack.getCreatedAt());

        return promotionPackDTO;
    }

    public PromotionPack toEntity(PromotionPackDTO promotionPackDTO) {
        PromotionPack promotionPack = new PromotionPack();

        promotionPack.setPrice(promotionPackDTO.getPrice());
        promotionPack.setIsActive(promotionPackDTO.getIsActive());
        promotionPack.setIsDeleted(promotionPackDTO.getIsDeleted());
        promotionPack.setPack(packMapper.toEntity(packService.getPackById(promotionPackDTO.getIdPack())));
        promotionPack.setCreatedBy(entityService.getEntityById(promotionPackDTO.getCreatedBy()));
        promotionPack.setFinishedAt(promotionPackDTO.getFinishedAt());
        promotionPack.setCreatedAt(promotionPackDTO.getCreatedAt());

        return promotionPack;
    }
}

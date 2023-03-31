package com.luxrest.rm.Promotion;

import com.luxrest.rm.Entity.EntityService;
import com.luxrest.rm.Pack.PackMapper;
import com.luxrest.rm.Pack.PackService;
import com.luxrest.rm.Product.ProductMapper;
import com.luxrest.rm.Product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionMapper {

    private final EntityService entityService;

    private final ProductService productService;

    private final ProductMapper productMapper;

    private final PackMapper packMapper;

    private final PackService packService;

    public PromotionDTO toDTO(Promotion promotion) {
        PromotionDTO promotionProductDTO = new PromotionDTO();

        promotionProductDTO.setIdPromotion(promotion.getIdPromotion());
        promotionProductDTO.setPrice(promotion.getPrice());
        promotionProductDTO.setIsActive(promotion.getIsActive());
        promotionProductDTO.setIsDeleted(promotion.getIsDeleted());
        promotionProductDTO.setIdProduct(promotion.getProduct().getId());
        promotionProductDTO.setIdPack(promotion.getPack().getId());
        promotionProductDTO.setCreatedBy(promotion.getCreatedBy().getId());
        promotionProductDTO.setFinishedAt(promotion.getFinishedAt());
        promotionProductDTO.setCreatedAt(promotion.getCreatedAt());

        return promotionProductDTO;
    }

    public Promotion toEntity(PromotionDTO promotionDTO) {
        Promotion promotion = new Promotion();

        promotion.setPrice(promotionDTO.getPrice());
        promotion.setIsActive(promotionDTO.getIsActive());
        promotion.setIsDeleted(promotionDTO.getIsDeleted());
        promotion.setProduct(productMapper.toEntity(productService.getProductById(promotionDTO.getIdProduct())));
        promotion.setPack(packMapper.toEntity(packService.getPackById(promotionDTO.getIdPack())));
        promotion.setCreatedBy(entityService.getEntityById(promotionDTO.getCreatedBy()));
        promotion.setFinishedAt(promotionDTO.getFinishedAt());
        promotion.setCreatedAt(promotionDTO.getCreatedAt());

        return promotion;
    }
}
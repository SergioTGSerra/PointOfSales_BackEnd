package com.luxrest.rm.PromotionProduct;

import com.luxrest.rm.Entity.EntityService;
import com.luxrest.rm.Product.ProductMapper;
import com.luxrest.rm.Product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionProductMapper {

    private final EntityService entityService;

    private final ProductService productService;

    private final ProductMapper productMapper;

    public PromotionProductDTO toDTO(PromotionProduct promotionProduct) {
        PromotionProductDTO promotionProductDTO = new PromotionProductDTO();

        promotionProductDTO.setIdPromotion(promotionProduct.getIdPromotion());
        promotionProductDTO.setPrice(promotionProduct.getPrice());
        promotionProductDTO.setIsActive(promotionProduct.getIsActive());
        promotionProductDTO.setIsDeleted(promotionProduct.getIsDeleted());
        promotionProductDTO.setIdProduct(promotionProduct.getProduct().getId());
        promotionProductDTO.setCreatedBy(promotionProduct.getCreatedBy().getId());
        promotionProductDTO.setFinishedAt(promotionProduct.getFinishedAt());
        promotionProductDTO.setCreatedAt(promotionProduct.getCreatedAt());

        return promotionProductDTO;
    }

    public PromotionProduct toEntity(PromotionProductDTO promotionProductDTO) {
        PromotionProduct promotionProduct = new PromotionProduct();

        promotionProduct.setPrice(promotionProductDTO.getPrice());
        promotionProduct.setIsActive(promotionProductDTO.getIsActive());
        promotionProduct.setIsDeleted(promotionProductDTO.getIsDeleted());
        promotionProduct.setProduct(productMapper.toEntity(productService.getProductById(promotionProductDTO.getIdProduct())));
        promotionProduct.setCreatedBy(entityService.getEntityById(promotionProductDTO.getCreatedBy()));
        promotionProduct.setFinishedAt(promotionProductDTO.getFinishedAt());
        promotionProduct.setCreatedAt(promotionProductDTO.getCreatedAt());

        return promotionProduct;
    }
}
package com.luxrest.rm.PromotionProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionProductRepository extends JpaRepository<PromotionProduct, PromotionProduct.PromotionProductPK> {
}

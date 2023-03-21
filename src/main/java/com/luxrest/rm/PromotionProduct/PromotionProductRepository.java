package com.luxrest.rm.PromotionProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionProductRepository extends JpaRepository<PromotionProduct, Integer> {
    List<PromotionProduct> findByProduct_Id(Integer productId);
}

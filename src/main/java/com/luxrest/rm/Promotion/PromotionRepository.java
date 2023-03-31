package com.luxrest.rm.Promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    List<Promotion> findByProduct_Id(Integer productId);
    List<Promotion> findByPack_Id(Integer packId);
}

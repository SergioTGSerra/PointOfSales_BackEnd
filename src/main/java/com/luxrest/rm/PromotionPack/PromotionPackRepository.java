package com.luxrest.rm.PromotionPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionPackRepository extends JpaRepository<PromotionPack, PromotionPack.PromotionPackPK> {
}
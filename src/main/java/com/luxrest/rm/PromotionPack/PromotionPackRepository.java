package com.luxrest.rm.PromotionPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionPackRepository extends JpaRepository<PromotionPack, Integer> {
    List<PromotionPack> findByPack_Id(Integer pack_id);
}
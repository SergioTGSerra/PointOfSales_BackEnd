package com.luxrest.rm.PromotionPack;

import com.luxrest.rm.Pack.Pack;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@jakarta.persistence.Entity
@Table(name = "promotion_packs")
public class PromotionPack {
    @EmbeddedId
    private PromotionPackPK id_pack;

    private String price;

    @Data
    @Embeddable
    static class PromotionPackPK implements Serializable {
        @OneToOne
        private Pack id_pack;
    }
}
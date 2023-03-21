package com.luxrest.rm.PromotionPack;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.Pack.Pack;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "promotion_packs")
public class PromotionPack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromotion;

    private Double price;

    private Boolean isActive;

    private Boolean isDeleted;
    @ManyToOne
    private Pack pack;

    @ManyToOne
    private Entity createdBy;

    private Date finishedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }
}
package com.luxrest.rm.PromotionProduct;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "promotions_products")
public class PromotionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromotion;

    private Double price;

    private Boolean isActive;

    private Boolean isDeleted;

    @ManyToOne
    private Product product;

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
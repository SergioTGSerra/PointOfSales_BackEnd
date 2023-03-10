package com.luxrest.rm.PromotionProduct;

import com.luxrest.rm.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@jakarta.persistence.Entity
@Table(name = "promotions_products")
public class PromotionProduct {
    @Id
    private PromotionProductPK id_product;

    private double price;

    @Data
    @Embeddable
    static class PromotionProductPK implements Serializable {
        @OneToOne
        private Product id_product;
    }
}
package com.luxrest.rm.PackProduct;

import com.luxrest.rm.Pack.Pack;
import com.luxrest.rm.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Optional;

@Data
@jakarta.persistence.Entity
@Table(name = "packs_products")
public class PackProduct {
    @Id
    private PackProductPK id;

    private Double price;

    @Data
    @Embeddable
    public static class PackProductPK implements Serializable {

        @ManyToOne
        private Pack pack;

        @ManyToOne
        private Product product;
    }
}
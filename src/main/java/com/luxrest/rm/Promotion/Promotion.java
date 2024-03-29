package com.luxrest.rm.Promotion;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.Pack.Pack;
import com.luxrest.rm.Product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double price;

    private Boolean isActive;

    private Boolean isDeleted;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Pack pack;

    @ManyToOne
    private Entity createdBy;

    private Date finishedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
        if(this.isActive == null){
            this.isActive = true;
        }
    }
}
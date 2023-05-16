package com.luxrest.rm.Product;

import com.luxrest.rm.Category.Category;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;

    private Boolean isActive;

    private Boolean isDeleted;

    @Lob
    private byte[] image;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Tax tax;

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
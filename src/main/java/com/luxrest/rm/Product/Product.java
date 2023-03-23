package com.luxrest.rm.Product;

import com.luxrest.rm.Category.Category;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    private Category category;

    @ManyToOne
    private Tax tax;
}
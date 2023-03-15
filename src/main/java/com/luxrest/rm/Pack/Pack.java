package com.luxrest.rm.Pack;

import com.luxrest.rm.Category.Category;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "packs")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;

    private Boolean isActive;

    private Boolean isDeleted;

    @ManyToOne
    private Category idCategory;

    @ManyToOne
    private Tax idTax;
}
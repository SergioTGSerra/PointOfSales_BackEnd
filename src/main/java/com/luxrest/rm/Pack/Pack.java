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
    private long id;

    private String name;

    private double price;

    private int stock;

    private boolean is_active;

    private boolean is_deleted;

    @ManyToOne
    private Category id_category;

    @ManyToOne
    private Tax id_tax;
}
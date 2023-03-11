package com.luxrest.rm.Product;

import com.luxrest.rm.Category.Category;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Price is mandatory")
    private Double price;

    @NotNull(message = "Stock is mandatory")
    private Integer stock;

    @NotNull
    private Boolean isActive;

    @NotNull
    private Boolean isDeleted;

    @NotNull(message = "Category is mandatory")
    @ManyToOne
    private Category category;

    @NotNull(message = "Tax is mandatory")
    @ManyToOne
    private Tax tax;
}
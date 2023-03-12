package com.luxrest.rm.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;
    @NotNull
    private Boolean isActive;
    private Boolean isDeleted;
    @NotNull(message = "Category id is mandatory")
    private Integer categoryId;
    @NotNull(message = "Tax id is mandatory")
    private Integer taxId;
}
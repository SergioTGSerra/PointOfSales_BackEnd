package com.luxrest.rm.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Price is mandatory")
    private Double price;
    @NotNull(message = "Stock is mandatory")
    private Integer stock;
    @NotNull
    private Boolean isActive;
    private Boolean isDeleted;
    @NotNull(message = "Category id is mandatory")
    private Integer categoryId;
    @NotNull(message = "Tax id is mandatory")
    private Integer taxId;
}
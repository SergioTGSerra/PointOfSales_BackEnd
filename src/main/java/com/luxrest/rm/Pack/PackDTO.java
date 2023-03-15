package com.luxrest.rm.Pack;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PackDTO {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;
    @NotNull
    private Boolean is_active;

    private Boolean is_deleted;
    @NotNull(message = "Category id is mandatory")
    private Integer idCategory;
    @NotNull(message = "Tax id is mandatory")
    private Integer idTax;
}

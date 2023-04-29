package com.luxrest.rm.Pack;

import com.luxrest.rm.PackProduct.PackProductDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PackRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer stock;
    private Boolean isActive;
    @NotNull(message = "Category is mandatory")
    private Integer category;
    @NotNull
    private List<PackProductDTO> packLine; //Prodcut Price
}

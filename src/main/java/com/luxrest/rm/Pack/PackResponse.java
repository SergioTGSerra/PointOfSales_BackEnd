package com.luxrest.rm.Pack;

import com.luxrest.rm.PackProduct.PackProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class PackResponse {
    private Integer id;
    private String name;
    private Integer stock;
    private Boolean isActive;
    private String category;
    private List<PackProductDTO> packLine;
}

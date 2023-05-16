package com.luxrest.rm.Product;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Boolean isActive;
    private byte[] image;
    private String category;
    private Double tax;
}
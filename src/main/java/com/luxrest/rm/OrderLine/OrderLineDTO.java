package com.luxrest.rm.OrderLine;

import lombok.Data;

@Data
public class OrderLineDTO {
    private Integer quantity;
    private Double price;
    private Double tax;
    private Integer product;
    private Integer pack;
}
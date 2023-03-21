package com.luxrest.rm.PromotionProduct;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PromotionProductDTO {

    private Integer idPromotion;

    @NotNull
    private Double price;

    @NotNull
    private Boolean isActive;

    private Boolean isDeleted;

    @NotNull(message = "Product id is mandatory")
    private Integer idProduct;

    @NotNull(message = "Entity id is mandatory")
    private Long createdBy;

    private Date finishedAt;

    @NotNull
    private Date createdAt;
}
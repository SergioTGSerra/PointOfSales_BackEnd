package com.luxrest.rm.Promotion;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PromotionDTO {

    private Integer idPromotion;

    @NotNull
    private Double price;

    @NotNull
    private Boolean isActive;

    private Boolean isDeleted;

    private Integer idProduct;

    private Integer idPack;

    @NotNull(message = "Entity id is mandatory")
    private Long createdBy;

    private Date finishedAt;

    @NotNull
    private Date createdAt;
}
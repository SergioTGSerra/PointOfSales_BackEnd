package com.luxrest.rm.PromotionPack;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PromotionPackDTO {

    private Integer idPromotion;

    @NotNull
    private Double price;

    @NotNull
    private Boolean isActive;

    private Boolean isDeleted;

    @NotNull(message = "Pack id is mandatory")
    private Integer idPack;

    @NotNull(message = "Entity id is mandatory")
    private Long createdBy;

    private Date finishedAt;

    @NotNull
    private Date createdAt;
}
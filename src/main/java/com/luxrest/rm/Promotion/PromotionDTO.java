package com.luxrest.rm.Promotion;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PromotionDTO {

    private Integer id;

    @NotNull
    private Double price;

    @NotNull
    private Boolean isActive;

    private Boolean isDeleted;

    private Integer idProduct;

    private Integer idPack;

    private Date finishedAt;

    @NotNull
    private Date createdAt;
}
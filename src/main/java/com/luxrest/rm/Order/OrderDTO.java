package com.luxrest.rm.Order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    @NotNull
    private Double ammount;
    @NotBlank
    private String orderNote;
    private Boolean isDeleted;
    @NotNull
    private Integer idStatus;
    @NotNull
    private Integer idPaymentMethod;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date createdAt;
    @NotNull
    private List<Integer> products;
}

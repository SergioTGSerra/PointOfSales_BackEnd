package com.luxrest.rm.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class OrderDTO {
    private Long id;
    @NotNull
    private Double ammount;
    @NotBlank
    private String orderNote;
    @JsonIgnore
    private Boolean isDeleted;
    @NotNull
    private Integer idStatus;
    @NotNull
    private Integer idPaymentMethod;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date createdAt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Map<Integer, Integer> productQuantity;
}

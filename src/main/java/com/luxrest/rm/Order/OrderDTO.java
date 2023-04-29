package com.luxrest.rm.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxrest.rm.OrderItem.OrderItem;
import com.luxrest.rm.OrderStatus.Order_Status;
import com.luxrest.rm.PaymentMethod.Payment_Method;
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
    @JsonIgnore
    private Boolean isDeleted;
    @NotNull
    private Order_Status orderStatus;
    @NotNull
    private Payment_Method paymentMethod;
    @NotNull
    private Long createdBy;
    @NotNull
    private Date createdAt;
    @NotNull
    private List<OrderItem> orderProductLine;
    @NotNull
    private List<OrderItem> orderPackLine;
}

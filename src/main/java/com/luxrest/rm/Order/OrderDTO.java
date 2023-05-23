package com.luxrest.rm.Order;

import com.luxrest.rm.OrderLine.OrderLineDTO;
import com.luxrest.rm.OrderStatus.Order_Status;
import com.luxrest.rm.PaymentMethod.Payment_Method;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Double amount;
    private String orderNote;
    @NotNull
    private Order_Status orderStatus;
    @NotNull
    private Payment_Method paymentMethod;
    private Date createdAt;
    private List<OrderLineDTO> orderLine;
}

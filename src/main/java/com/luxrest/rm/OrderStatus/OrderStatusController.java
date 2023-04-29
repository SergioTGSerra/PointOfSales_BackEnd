package com.luxrest.rm.OrderStatus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/orders-status")
public class OrderStatusController {
    @GetMapping
    public List<Order_Status> getOrderStatus() {
        return Arrays.asList(Order_Status.values());
    }
}

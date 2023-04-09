package com.luxrest.rm.OrderStatus;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderStatus")
@AllArgsConstructor
public class OrderStatusController {
    private final OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusService.getAllOrderStatus();
    }

    @GetMapping("/{id}")
    public OrderStatus getOrderStatusById(@PathVariable Integer id){
        return orderStatusService.getOrderStatusById(id);
    }

    @PostMapping
    public OrderStatus saveOrderStatus(@RequestBody @Valid OrderStatus orderStatus){
        return orderStatusService.createOrderStatus(orderStatus);
    }

    @PutMapping("/{id}")
    public OrderStatus updateOrderStatus(@PathVariable Integer id, @RequestBody @Valid OrderStatus orderStatus){
        return orderStatusService.updateOrderStatus(id, orderStatus);
    }

    @DeleteMapping("/{id}")
    public OrderStatus deleteOrderStatus(@PathVariable Integer id){
        return orderStatusService.deleteOrderStatus(id);
    }

}

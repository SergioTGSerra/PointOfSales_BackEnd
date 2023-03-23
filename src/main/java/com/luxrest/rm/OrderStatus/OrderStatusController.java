package com.luxrest.rm.OrderStatus;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

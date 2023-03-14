package com.luxrest.rm.Order;

import com.luxrest.rm.Product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    /*@PostMapping("/{orderId}/products")
    public ResponseEntity<OrderDTO> addProductToOrder(@PathVariable Long orderId, @RequestBody ProductRequestDTO productRequestDTO) {
        Order updatedOrder = orderService.addProductToOrder(orderId, productRequestDTO);
        OrderResponseDTO orderResponseDTO = orderService.mapToOrderResponseDTO(updatedOrder);
        return ResponseEntity.ok(orderResponseDTO);
    }*/

}

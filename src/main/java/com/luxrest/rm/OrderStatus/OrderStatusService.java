package com.luxrest.rm.OrderStatus;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrderStatusService {
    private final OrderStatusRepository orderStatusRepository;
    public List<OrderStatus> getAllOrderStatus(){
        return orderStatusRepository.findAll();
    }

    public OrderStatus getOrderStatusById(Integer id){
        return orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found: " + id));
    }

    public OrderStatus createOrderStatus(OrderStatus orderStatus){
        if(orderStatus.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        return orderStatusRepository.save(orderStatus);
    }

    public OrderStatus updateOrderStatus(Integer id, OrderStatus orderStatus){
        orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found"));
        orderStatus.setId(id);
        return orderStatusRepository.save(orderStatus);
    }

    public OrderStatus deleteOrderStatus(Integer id){
        OrderStatus deletedOrderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found"));
        deletedOrderStatus.setIsDeleted(true);
        return orderStatusRepository.save(deletedOrderStatus);
    }
}

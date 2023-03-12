package com.luxrest.rm.OrderStatus;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;
    public OrderStatusService(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    public List<OrderStatus> getAllOrderStatus(){
        return orderStatusRepository.findAll();
    }

    public OrderStatus getOrderStatusById(Integer id){
        return orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found: " + id));
    }

    public OrderStatus saveOrderStatus(OrderStatus orderStatus){
        return orderStatusRepository.save(orderStatus);
    }

    public OrderStatus updateOrderStatus(Integer id, OrderStatus orderStatus){
        OrderStatus existingOrderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found"));
        existingOrderStatus.setName(orderStatus.getName());
        return orderStatusRepository.save(existingOrderStatus);
    }

    public OrderStatus deleteOrderStatus(Integer id){
        OrderStatus deletedOrderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order Status not found"));
        deletedOrderStatus.setIsDeleted(true);
        return orderStatusRepository.save(deletedOrderStatus);
    }
}

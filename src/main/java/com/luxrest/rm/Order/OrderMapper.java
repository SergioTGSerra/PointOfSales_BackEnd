package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final EntityService entityService;
    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setAmmount(order.getAmount());
        orderDTO.setOrderNote(order.getOrderNote());
        orderDTO.setIsDeleted(order.getIsDeleted());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setPaymentMethod(order.getPaymentMethod());
        orderDTO.setCreatedBy(order.getCreatedBy().getId());
        orderDTO.setCreatedAt(order.getCreatedAt());

        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO) {

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setAmount(orderDTO.getAmmount());
        order.setOrderNote(orderDTO.getOrderNote());
        order.setIsDeleted(orderDTO.getIsDeleted());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setPaymentMethod(orderDTO.getPaymentMethod());

        return order;
    }
}

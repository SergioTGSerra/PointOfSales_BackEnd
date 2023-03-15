package com.luxrest.rm.Order;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setAmmount(order.getAmmount());
        orderDTO.setOrderNote(order.getOrderNote());
        orderDTO.setIsDeleted(order.getIsDeleted());
        orderDTO.setIdStatus(order.getIdSatus().getId());
        orderDTO.setIdPaymentMethod(order.getIdPaymentMethod().getId());
        orderDTO.setCreatedBy(order.getCreatedBy().getId());
        orderDTO.setCreatedAt(order.getCreatedAt());

        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO) {

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setAmmount(orderDTO.getAmmount());
        order.setOrderNote(orderDTO.getOrderNote());
        order.setIsDeleted(orderDTO.getIsDeleted());

        return order;
    }
}

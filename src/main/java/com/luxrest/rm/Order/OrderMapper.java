package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.EntityService;
import com.luxrest.rm.OrderStatus.OrderStatusService;
import com.luxrest.rm.PaymentMethod.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final OrderStatusService orderStatusService;
    private final PaymentMethodService paymentMethodService;
    private final EntityService entityService;
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
        order.setIdSatus(orderStatusService.getOrderStatusById(orderDTO.getIdStatus()));
        order.setIdPaymentMethod(paymentMethodService.getPaymentMethodById(orderDTO.getIdPaymentMethod()));
        order.setCreatedBy(entityService.getEntityById(orderDTO.getCreatedBy()));

        return order;
    }
}

package com.luxrest.rm.Order;

import com.luxrest.rm.OrderLine.OrderLine;
import com.luxrest.rm.OrderLine.OrderLineDTO;
import com.luxrest.rm.OrderLine.OrderLineMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderMapper {

    private final OrderLineMapper orderLineMapper;

    public OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setAmount(order.getAmount());
        orderDTO.setOrderNote(order.getOrderNote());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setPaymentMethod(order.getPaymentMethod());

        List<OrderLineDTO> orderLineDTOList = new ArrayList<>();
        for(OrderLine orderLine : order.getOrderLine())
            orderLineDTOList.add(orderLineMapper.toDTO(orderLine));

        orderDTO.setOrderLine(orderLineDTOList);

        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO) {

        Order order = new Order();

        order.setOrderNote(orderDTO.getOrderNote());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setPaymentMethod(orderDTO.getPaymentMethod());

        List<OrderLine> orderLine = new ArrayList<>();
        Double amount = null;
        for(OrderLineDTO orderLineDTO : orderDTO.getOrderLine()){
            orderLine.add(orderLineMapper.toEntity(orderLineDTO));
            amount += orderLineMapper.toEntity(orderLineDTO).getPrice();
        }

        order.setAmount(amount);
        order.setOrderLine(orderLine);

        return order;
    }
}

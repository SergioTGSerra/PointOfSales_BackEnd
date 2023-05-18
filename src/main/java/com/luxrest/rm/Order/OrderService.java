package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.OrderLine.OrderLine;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO getOrderById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"+ id));
        return orderMapper.toDTO(order);
    }


    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);

        Order createdOrder = orderRepository.save(order);

        for(OrderLine orderLine : createdOrder.getOrderLine())
            orderLine.setOrder(createdOrder);

        createdOrder = orderRepository.save(createdOrder);

        return orderMapper.toDTO(createdOrder);
    }

    @Transactional
    public OrderDTO deleteOrder(Long id){
        Order deletedOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found" + id));
        deletedOrder.setIsDeleted(true);
        return orderMapper.toDTO(orderRepository.save(deletedOrder));
    }

    @Transactional
    public OrderDTO getLoggedOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Order> orders = orderRepository.findByCreatedBy((Entity) authentication.getPrincipal());
        return (OrderDTO) orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
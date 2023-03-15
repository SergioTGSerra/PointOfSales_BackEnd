package com.luxrest.rm.Order;

import com.luxrest.rm.OrderItem.OrderItem;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        order.setIsDeleted(false);

        List<Product> products = productRepository.findAllById(orderDTO.getProductQuantity().keySet());
        List<OrderItem> orderItems = new ArrayList<>();
        for (Product product : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(new OrderItem.OrderItemPK(order, product));
            orderItem.setQuantity(orderDTO.getProductQuantity().get(product.getId()));
            orderItem.setPrice(product.getPrice());
            orderItem.setId_tax(product.getTax());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    @Transactional
    public OrderDTO deleteOrder(Long id){
        Order deletedOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found" + id));
        deletedOrder.setIsDeleted(true);
        return orderMapper.toDTO(orderRepository.save(deletedOrder));
    }
}
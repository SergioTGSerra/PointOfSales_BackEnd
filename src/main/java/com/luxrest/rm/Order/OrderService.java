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

        //Get Products
        List<Product> products = productRepository.findAllById(orderDTO.getOrderLine().keySet());
        List<OrderItem> orderItems = new ArrayList<>();
        for (Product product : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            //Get Quantity of this product
            orderItem.setQuantity(orderDTO.getOrderLine().get(product.getId()));
            orderItem.setPrice(product.getPrice());
            orderItem.setTax(product.getTax());
            orderItems.add(orderItem);
        }
        //Está feito para o produto fazer para o pack
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
package com.luxrest.rm.Order;

import com.luxrest.rm.OrderItem.OrderItem;
import com.luxrest.rm.OrderStatus.OrderStatusService;
import com.luxrest.rm.PaymentMethod.PaymentMethodService;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    private final OrderStatusService orderStatusService;
    private final PaymentMethodService paymentMethodService;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ProductRepository productRepository, OrderStatusService orderStatusService, PaymentMethodService paymentMethodService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
        this.orderStatusService = orderStatusService;
        this.paymentMethodService = paymentMethodService;
    }

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
        order.setIdSatus(orderStatusService.getOrderStatusById(orderDTO.getIdStatus()));
        order.setIdPaymentMethod(paymentMethodService.getPaymentMethodById(orderDTO.getIdPaymentMethod()));
        List<Product> products = productRepository.findAllById(orderDTO.getProducts());
        List<OrderItem> orderItems = new ArrayList<>();
        for (Product product : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(new OrderItem.OrderItemPK(order, product));
            orderItem.setQuantity(1);
            orderItem.setPrice(product.getPrice());
            orderItem.setId_tax(product.getTax());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);

        return orderMapper.toDTO(orderRepository.save(order));
    }

}

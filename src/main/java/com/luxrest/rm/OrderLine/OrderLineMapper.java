package com.luxrest.rm.OrderLine;

import com.luxrest.rm.Pack.Pack;
import com.luxrest.rm.Pack.PackRepository;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderLineMapper {

    private final ProductRepository productRepository;

    private final PackRepository packRepository;


    public OrderLineDTO toDTO(OrderLine orderLine){
        OrderLineDTO orderLineDTO = new OrderLineDTO();

        orderLineDTO.setPrice(orderLine.getPrice());
        orderLineDTO.setQuantity(orderLine.getQuantity());
        orderLineDTO.setPack(orderLine.getPack().getId());
        orderLineDTO.setProduct(orderLine.getProduct().getId());
        orderLineDTO.setTax(orderLineDTO.getTax());

        return orderLineDTO;
    }

    public OrderLine toEntity(OrderLineDTO orderLineDTO){

        OrderLine orderLine = new OrderLine();

        orderLine.setQuantity(orderLineDTO.getQuantity());


        Product product = productRepository.findById(orderLineDTO.getProduct())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"+ orderLineDTO.getProduct()));

        orderLine.setPrice(product.getPrice());
        orderLine.setProduct(product);
        orderLine.setTax(product.getTax().getValue());

        Pack pack = packRepository.findById(orderLineDTO.getPack())
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ orderLineDTO.getPack()));

        orderLine.setPack(pack);

        return orderLine;

    }
}
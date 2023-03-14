package com.luxrest.rm.OrderItem;

import com.luxrest.rm.Order.Order;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@jakarta.persistence.Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    private OrderItemPK id;

    private int quantity;

    private double price;

    @ManyToOne
    private Tax id_tax;

    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderItemPK implements Serializable {
        @ManyToOne
        private Order order;
        @ManyToOne
        private Product product;
    }
}
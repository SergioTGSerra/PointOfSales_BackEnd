package com.luxrest.rm.OrderItem;

import com.luxrest.rm.Order.Order;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@jakarta.persistence.Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    private OrderProductPK id;

    private int quantity;

    private double price;

    @ManyToOne
    private Tax id_tax;

    @Data
    @Embeddable
    static class OrderProductPK implements Serializable {

        @ManyToOne
        private Order order;

        @ManyToOne
        private Product product;
    }
}
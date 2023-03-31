package com.luxrest.rm.OrderItem;

import com.luxrest.rm.Order.Order;
import com.luxrest.rm.Pack.Pack;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    private Long id;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private Tax id_tax;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Pack pack;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    private void onCreate() {
        created_at = new Date();
    }
}
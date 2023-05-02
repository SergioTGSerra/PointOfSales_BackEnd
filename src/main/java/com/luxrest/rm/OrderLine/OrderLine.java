package com.luxrest.rm.OrderLine;

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
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double price;

    private Double tax;

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
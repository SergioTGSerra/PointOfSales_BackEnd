package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.OrderItem.OrderItem;
import com.luxrest.rm.OrderStatus.Order_Status;
import com.luxrest.rm.PaymentMethod.Payment_Method;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@jakarta.persistence.Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String orderNote;

    private Boolean isDeleted;

    @Enumerated(EnumType.STRING)
    private Order_Status orderStatus;

    @Enumerated(EnumType.STRING)
    private Payment_Method paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    private Entity createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = new Date();
    }
}
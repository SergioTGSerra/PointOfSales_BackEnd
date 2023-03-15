package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.OrderItem.OrderItem;
import com.luxrest.rm.OrderStatus.OrderStatus;
import com.luxrest.rm.PaymentMethod.PaymentMethod;
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

    private Double ammount;

    private String orderNote;

    private Boolean isDeleted;

    @ManyToOne
    private OrderStatus idSatus;

    @ManyToOne
    private PaymentMethod idPaymentMethod;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL)
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
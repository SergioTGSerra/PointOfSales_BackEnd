package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.OrderStatus.OrderStatus;
import com.luxrest.rm.PaymentMethod.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double ammount;

    private String orderNote;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    private boolean is_deleted;

    @ManyToOne
    private OrderStatus id_satus;

    @ManyToOne
    private PaymentMethod id_payment_method;

    @ManyToOne
    private Entity created_by;

    @PrePersist
    private void onCreate() {
        created_at = new Date();
    }
}
package com.luxrest.rm.Order;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.OrderLine.OrderLine;
import com.luxrest.rm.OrderStatus.Order_Status;
import com.luxrest.rm.PaymentMethod.Payment_Method;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

    @Enumerated(EnumType.STRING)
    private Order_Status orderStatus;

    @Enumerated(EnumType.STRING)
    private Payment_Method paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLine;

    private Boolean isDeleted;

    @ManyToOne
    private Entity createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        if (this.isDeleted == null)
            this.isDeleted = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        createdBy = (Entity) authentication.getPrincipal();
    }
}
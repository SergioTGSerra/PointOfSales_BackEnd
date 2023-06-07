package com.luxrest.rm.Expense;

import com.luxrest.rm.Entity.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String note;

    private Double amount;

    @ManyToOne
    private Entity createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        createdBy = (Entity) authentication.getPrincipal();
    }
}
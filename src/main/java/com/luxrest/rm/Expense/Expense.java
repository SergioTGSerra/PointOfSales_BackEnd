package com.luxrest.rm.Expense;

import com.luxrest.rm.Entity.Entity;
import jakarta.persistence.*;
import lombok.Data;

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
}
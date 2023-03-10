package com.luxrest.rm.Expenses;

import com.luxrest.rm.Entity.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String note;

    private double amount;

    @ManyToOne
    private Entity id_entity;
}
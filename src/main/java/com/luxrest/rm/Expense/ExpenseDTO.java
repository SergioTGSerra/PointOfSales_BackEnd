package com.luxrest.rm.Expense;

import lombok.Data;

import java.util.Date;

@Data
public class ExpenseDTO {

    private Long id;

    private String note;

    private Double amount;

    private String createdBy;

    private Date createdAt;
}
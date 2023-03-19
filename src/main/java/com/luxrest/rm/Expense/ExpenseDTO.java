package com.luxrest.rm.Expense;

import lombok.Data;

@Data
public class ExpenseDTO {

    private Long id;

    private String note;

    private Double amount;

    private Long createdBy;
}
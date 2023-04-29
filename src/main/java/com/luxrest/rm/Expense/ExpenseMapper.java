package com.luxrest.rm.Expense;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseMapper {

    public ExpenseDTO toDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId(expense.getId());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setNote(expense.getNote());

        return expenseDTO;
    }

    public Expense toEntity(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();

        expense.setAmount(expenseDTO.getAmount());
        expense.setNote(expenseDTO.getNote());

        return expense;
    }
}
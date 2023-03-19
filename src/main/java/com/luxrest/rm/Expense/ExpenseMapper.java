package com.luxrest.rm.Expense;

import com.luxrest.rm.Entity.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExpenseMapper {

    private final EntityService entityService;

    public ExpenseDTO toDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId(expense.getId());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setNote(expense.getNote());
        expenseDTO.setCreatedBy(expense.getCreatedBy().getId());

        return expenseDTO;
    }

    public Expense toEntity(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();

        expense.setAmount(expenseDTO.getAmount());
        expense.setNote(expenseDTO.getNote());
        expense.setCreatedBy(entityService.getEntityById(expenseDTO.getCreatedBy()));

        return expense;
    }
}
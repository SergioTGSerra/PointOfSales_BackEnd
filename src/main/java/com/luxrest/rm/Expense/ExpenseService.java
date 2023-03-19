package com.luxrest.rm.Expense;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(expenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ExpenseDTO getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense not found"+ id));
        return expenseMapper.toDTO(expense);
    }


    @Transactional
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense expense = expenseMapper.toEntity(expenseDTO);
        return expenseMapper.toDTO(expenseRepository.save(expense));
    }

    @Transactional
    public ExpenseDTO deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense not found" + id));
        expenseRepository.delete(expense);
        return expenseMapper.toDTO(expense);
    }
}
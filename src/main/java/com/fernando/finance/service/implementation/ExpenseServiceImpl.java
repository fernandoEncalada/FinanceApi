package com.fernando.finance.service.implementation;

import com.fernando.finance.model.dbmo.Budget;
import com.fernando.finance.model.dbmo.Category;
import com.fernando.finance.model.dbmo.Expense;
import com.fernando.finance.model.dto.expense.ExpenseRequestDto;
import com.fernando.finance.model.dto.expense.ExpenseResponseDto;
import com.fernando.finance.model.repository.BudgetRepository;
import com.fernando.finance.model.repository.CategoryRepository;
import com.fernando.finance.model.repository.ExpenseRepository;
import com.fernando.finance.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ExpenseResponseDto> getAll() {
        return expenseRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private ExpenseResponseDto mapToDto(Expense expense) {
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
        expenseResponseDto.setId(expense.getId());
        expenseResponseDto.setDescription(expense.getDescription());
        expenseResponseDto.setAmount(expense.getAmount());
        expenseResponseDto.setCreatedAt(expense.getCreatedAt());
        expenseResponseDto.setUpdatedAt(expense.getUpdatedAt());
        expenseResponseDto.setCategory(expense.getCategory());

        return expenseResponseDto;
    }

    @Override
    public ExpenseResponseDto save(ExpenseRequestDto expenseDTO) {
        Budget budget = budgetRepository.findById(expenseDTO.getBudgetId())
                .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + expenseDTO.getBudgetId()));

        Category category = categoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + expenseDTO.getCategoryId()));

        Expense expense = Expense.builder()
                .description(expenseDTO.getDescription())
                .amount(expenseDTO.getAmount())
                .budget(budget)
                .category(category)
                .build();

        expense = expenseRepository.save(expense);
        return mapToDto(expense);
    }

    @Override
    public ExpenseResponseDto update(int id, ExpenseRequestDto expenseRequestDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("The expense with id: " + id + " does not exist"));
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setAmount(expenseRequestDto.getAmount());
        expense = expenseRepository.save(expense);
        return mapToDto(expense);
    }
}

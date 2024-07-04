package com.fernando.finance.service.implementation;

import com.fernando.finance.model.dbmo.Expense;
import com.fernando.finance.model.dto.expense.ExpenseRequestDto;
import com.fernando.finance.model.dto.expense.ExpenseResponseDto;
import com.fernando.finance.model.repository.ExpenseRepository;
import com.fernando.finance.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

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
        return expenseResponseDto;
    }

    @Override
    public ExpenseResponseDto save(ExpenseRequestDto expenseRequestDto) {
        Expense expense =  new Expense();
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setAmount(expenseRequestDto.getAmount());
//        expense.setCreatedAt(DateMethods.getActualDate());
//        expense.setUpdatedAt(DateMethods.getActualDate());
        expense = expenseRepository.save(expense);
        return mapToDto(expense);
    }

    @Override
    public ExpenseResponseDto update(int id, ExpenseRequestDto expenseRequestDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("The expense with id: " + id + " does not exist"));
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setAmount(expenseRequestDto.getAmount());
//        expense.setUpdatedAt(DateMethods.getActualDate());
        expense = expenseRepository.save(expense);
        return mapToDto(expense);
    }
}

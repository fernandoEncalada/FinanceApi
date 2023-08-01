package com.fernando.finance.service;

import com.fernando.finance.model.dto.expense.ExpenseRequestDto;
import com.fernando.finance.model.dto.expense.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {

    List<ExpenseResponseDto> getAll();

    ExpenseResponseDto save(ExpenseRequestDto expenseRequestDto);

    ExpenseResponseDto update(int id, ExpenseRequestDto expenseRequestDto);

}

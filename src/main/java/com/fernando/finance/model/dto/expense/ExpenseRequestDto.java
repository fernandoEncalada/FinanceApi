package com.fernando.finance.model.dto.expense;

import lombok.Data;

import java.sql.Date;

@Data
public class ExpenseRequestDto {
    private String description;
    private double amount;
}

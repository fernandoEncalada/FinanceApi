package com.fernando.finance.model.dto.expense;

import lombok.Data;

import java.sql.Date;

@Data
public class ExpenseResponseDto {
    private int id;
    private String description;
    private double amount;
    private Date createdAt;
    private Date updatedAt;
}

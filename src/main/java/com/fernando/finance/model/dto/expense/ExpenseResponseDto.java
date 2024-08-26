package com.fernando.finance.model.dto.expense;

import com.fernando.finance.model.dbmo.Category;
import lombok.Data;

import java.util.Date;


@Data
public class ExpenseResponseDto {
    private int id;
    private String description;
    private Category category;
    private double amount;
    private Date createdAt;
    private Date updatedAt;
}

package com.fernando.finance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BudgetDTO {

    private Double balance;
    private Date startDate;
    private Date endDate;
}

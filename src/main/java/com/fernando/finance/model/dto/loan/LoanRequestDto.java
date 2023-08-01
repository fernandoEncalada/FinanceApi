package com.fernando.finance.model.dto.loan;

import com.fernando.finance.model.StatusType;
import lombok.Data;

import java.sql.Date;

@Data
public class LoanRequestDto {
    private int idPerson;
    private String description;
    private double amount;
    private int status;
}

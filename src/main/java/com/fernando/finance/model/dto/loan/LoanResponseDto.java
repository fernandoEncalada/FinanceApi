package com.fernando.finance.model.dto.loan;

import com.fernando.finance.model.StatusType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class LoanResponseDto {
    private int id;
    private String description;
    private double amount;
    private Date createdAt;
    private Date updatedAt;
    private StatusType status;
    private String name;
}

package com.fernando.finance.model.dto.loan;

import com.fernando.finance.model.StatusType;
import lombok.Data;

import java.util.Date;

@Data
public class LoanResponseDto {
    private Integer id;
    private String description;
    private Double amount;
    private Date createdAt;
    private Date updatedAt;
    private StatusType status;
    private String name;
}

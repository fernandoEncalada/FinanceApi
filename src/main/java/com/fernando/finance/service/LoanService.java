package com.fernando.finance.service;

import com.fernando.finance.model.dto.loan.LoanRequestDto;
import com.fernando.finance.model.dto.loan.LoanResponseDto;

import java.util.List;

public interface LoanService {
    List<LoanResponseDto> get();
    LoanResponseDto save(LoanRequestDto loanRequestDto);
    LoanResponseDto update(int id, LoanRequestDto loanRequestDto);
}

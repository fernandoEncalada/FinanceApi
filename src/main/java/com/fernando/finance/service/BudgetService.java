
package com.fernando.finance.service;

import com.fernando.finance.model.dbmo.Budget;
import com.fernando.finance.model.dto.BudgetDTO;

import java.util.List;

public interface BudgetService {

    Budget createBudget(BudgetDTO budget);

    Budget getBudgetById(Long id);

    List<Budget> getAllBudgets();

    Budget updateBudget(Long id, Budget budget);

    void deleteBudget(Long id);
}

package com.fernando.finance.service.implementation;

import com.fernando.finance.model.dbmo.Budget;
import com.fernando.finance.model.dto.BudgetDTO;
import com.fernando.finance.model.repository.BudgetRepository;
import com.fernando.finance.service.BudgetService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Budget createBudget(BudgetDTO budgetDTO) {
        Budget budget = Budget.builder()
                .balance(budgetDTO.getBalance())
                .startDate(budgetDTO.getStartDate())
                .endDate(budgetDTO.getEndDate())
                .build();

        return budgetRepository.save(budget);
    }

    @Override
    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + id));
    }

    @Override
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget updateBudget(Long id, Budget budget) {
        Budget existingBudget = budgetRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + id));
        
        existingBudget.setBalance(budget.getBalance());
        existingBudget.setStartDate(budget.getStartDate());
        existingBudget.setEndDate(budget.getEndDate());
        existingBudget.setExpenses(budget.getExpenses());

        return budgetRepository.save(existingBudget);
    }

    @Override
    public void deleteBudget(Long id) {
        Budget budget = budgetRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + id));
        budgetRepository.delete(budget);
    }
}

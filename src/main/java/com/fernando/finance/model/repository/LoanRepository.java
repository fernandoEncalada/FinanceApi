package com.fernando.finance.model.repository;

import com.fernando.finance.model.dbmo.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Optional<Loan> findById(Integer id);
}

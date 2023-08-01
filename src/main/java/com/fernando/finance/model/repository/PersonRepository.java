package com.fernando.finance.model.repository;

import com.fernando.finance.model.dbmo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
